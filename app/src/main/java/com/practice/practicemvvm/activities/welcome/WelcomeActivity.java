package com.practice.practicemvvm.activities.welcome;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.practice.practicemvvm.R;
import com.practice.practicemvvm.recyclerviews.AddNewContactRecyclerViewAdapter;
import com.practice.practicemvvm.data.room.entities.Contacts;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.AndroidInjection;

public class WelcomeActivity extends AppCompatActivity implements WelcomeActivityContract.View,
        View.OnClickListener, AddNewContactRecyclerViewAdapter.ContactClickListener {


    private AddNewContactRecyclerViewAdapter addNewContactRecyclerViewAdapter;

    @BindView(R.id.welcome_view_country_bt_id)
    MaterialButton countryListBt;

    @BindView(R.id.welcome_no_contact_view_id)
    AppCompatTextView noContactFoundView;

    @BindView(R.id.welcome_recycler_view_id)
    RecyclerView contactRecyclerView;

    @BindView(R.id.welcome_add_card_view_id)
    MaterialCardView addContactCardViewId;

    @BindView(R.id.welcome_add_bt_id)
    FloatingActionButton addNewContactBt;

    @BindView(R.id.welcome_add_submit_bt_id)
    MaterialButton submitBt;

    @BindView(R.id.welcome_add_name_input_layout_id)
    TextInputLayout addNameInputLayout;

    @BindView(R.id.welcome_add_name_edit_text_id)
    TextInputEditText addNameEditTextId;

    @BindView(R.id.welcome_add_email_input_layout_id)
    TextInputLayout addEmailInputLayout;

    @BindView(R.id.welcome_add_email_edit_text_id)
    TextInputEditText addEmailEditText;

    private Unbinder unbinder;

    private boolean toggleView;

    private AlertDialog alertDialog;

    @Inject
    WelcomeActivityContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        this.unbinder = ButterKnife.bind(this);

        this.presenter.attachViewModel(this);

        this.submitBt.setOnClickListener(this);
        this.addNewContactBt.setOnClickListener(this);
        this.countryListBt.setOnClickListener(this);

        this.presenter.setUpEmailValidator(this.addEmailInputLayout);

        this.contactRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        this.addNewContactRecyclerViewAdapter = new AddNewContactRecyclerViewAdapter(this);
        this.contactRecyclerView.setAdapter(this.addNewContactRecyclerViewAdapter);

//        if(presenter.getContactList() != null)
//        this.addNewContactRecyclerViewAdapter.setListOfContacts(presenter.getContactList());
//
//        if(presenter.getContactList() != null && presenter.getContactList().size() > 0){
//
//            this.contactRecyclerView.setVisibility(View.VISIBLE);
//            this.noContactFoundView.setVisibility(View.GONE);
//
//        }else{
//
//            this.contactRecyclerView.setVisibility(View.GONE);
//            this.noContactFoundView.setVisibility(View.VISIBLE);
//        }
        LiveData<List<Contacts>> contactsLiveData = this.presenter.getLiveContactData();


        contactsLiveData.observe(this, contacts ->
                addNewContactRecyclerViewAdapter.setListOfContacts(contacts));

    }

    @Override
    protected void onStart() {
        super.onStart();
        this.presenter.subscribe();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.presenter.unSubscribe();
        this.unbinder.unbind();
        if(this.alertDialog != null){
            this.alertDialog.dismiss();
            this.alertDialog = null;
        }
    }

    @Override
    public void observeLiveData(LiveData<Integer> liveData){

//        liveData.observe(this, integer -> counterView.setText(String.valueOf(integer)));
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == this.addNewContactBt.getId()){

            this.toggleView = !this.toggleView;

            this.presenter.displayAddNewContactCard();

        }

        if(v.getId() == this.submitBt.getId()){

            if(this.submitBt.getVisibility() == View.VISIBLE){

                this.presenter.getUserInputs();
            }
        }

        if(v.getId() == this.countryListBt.getId()){

            this.presenter.openCountryListView(this);
        }
    }

    @Override
    public void getUserInputs(){

        String name = "";
        String email = "";

        if(this.addNameEditTextId != null && this.addNameEditTextId.getText() != null){

            name = this.addNameEditTextId.getText().toString();

        }

        if(this.addEmailEditText != null && this.addEmailEditText.getText() != null){

            email = this.addEmailEditText.getText().toString();
        }

        boolean validateEmail = this.presenter.validateEmail(email);

        if(validateEmail){

            addContactCardViewId.setVisibility(View.GONE);
            this.presenter.processData(name, email);
        }
    }

    @Override
    public void displayAddNewContactCard(){

        this.contactRecyclerView.setAlpha(this.toggleView ? 0.5f : 1f);
        this.contactRecyclerView.setEnabled(this.toggleView);
        this.addContactCardViewId.setVisibility(this.toggleView ? View.VISIBLE : View.GONE);

    }

    @Override
    public void dispatchLiveData(LiveData<List<Contacts>> contactsLiveData){
        contactsLiveData.observe(this, contacts ->{
            this.contactRecyclerView.setAlpha(1f);
            this.contactRecyclerView.setEnabled(true);
            this.addContactCardViewId.setVisibility(View.GONE);
            addNewContactRecyclerViewAdapter.setListOfContacts(contacts);
        });
    }

    @Override
    public void onContactClicked(Contacts contacts) {

        this.presenter.showDialogToRemove(contacts);
    }

    @Override
    public void showDialogToRemove(Contacts contacts){

        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        String name = contacts.getName();
        alertBuilder.setTitle("Delete Contacts");
        alertBuilder.setMessage("Do you like to delete " + name + "?");
        alertBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                presenter.deleteContact(contacts);
            }
        });
        alertBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        this.alertDialog = alertBuilder.create();
        alertDialog.show();
    }
}

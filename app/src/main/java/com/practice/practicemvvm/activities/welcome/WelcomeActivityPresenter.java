package com.practice.practicemvvm.activities.welcome;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.textfield.TextInputLayout;
import com.practice.practicemvvm.activities.welcome.countrylist.CountryListViewActivity;
import com.practice.practicemvvm.data.room.entities.Contacts;
import com.practice.practicemvvm.validators.EmailValidator;
import com.practice.practicemvvm.viewmodel.ViewModelFactory;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class WelcomeActivityPresenter implements WelcomeActivityContract.Presenter {

    private LiveData<List<Contacts>> contactsLiveData;

    private List<Contacts> contactsList = new ArrayList<>();

    private EmailValidator emailValidator;

    @NonNull
    private WelcomeActivityContract.View view;

    @NonNull
    private WelcomeViewModel welcomeViewModel;

//    @NonNull
//    private WelcomeActivityViewModelFactory welcomeActivityViewModelFactory;
    @NonNull
    private ViewModelFactory viewModelFactory;

    private LiveData<Integer> integerLiveData;

//
//    @Inject
//    WelcomeActivityPresenter(@NonNull WelcomeActivityContract.View view, @NonNull WelcomeActivityViewModelFactory welcomeActivityViewModelFactory){
//
//        this.view = view;
//        this.welcomeActivityViewModelFactory = welcomeActivityViewModelFactory;
//    }

    @Inject
    WelcomeActivityPresenter(@NonNull WelcomeActivityContract.View view, @NonNull ViewModelFactory viewModelFactory){

        this.view = view;
        this.viewModelFactory = viewModelFactory;
    }

    @Override
    public void showCurrentValue() {

        this.welcomeViewModel.getCurrentCounter();
    }

    @Override
    public void subscribe() {

        this.integerLiveData = this.welcomeViewModel.getInitialCounter();
        this.view.observeLiveData(this.integerLiveData);
    }

    @Override
    public void attachViewModel(FragmentActivity activity){

        this.welcomeViewModel = ViewModelProviders.of(activity, this.viewModelFactory).get(WelcomeViewModel.class);
    }

    @Override
    public void unSubscribe() {

    }

    @Override
    public void displayAddNewContactCard(){

        this.view.displayAddNewContactCard();
    }

    @Override
    public void setUpEmailValidator(TextInputLayout inputLayout){

        this.emailValidator = new EmailValidator(inputLayout);
    }

    @Override
    public void getUserInputs(){

        this.view.getUserInputs();
    }

    @Override
    public boolean validateEmail(String email){

       return this.emailValidator.validate(email);

    }

    @Override
    public void processData(String name, String email){

        this.contactsLiveData = this.welcomeViewModel.getAllContactList();

        this.welcomeViewModel.processData(name, email);

        this.view.dispatchLiveData(this.contactsLiveData);

    }

    @Override
    public LiveData<List<Contacts>> getLiveContactData(){

        return this.welcomeViewModel.getAllContactList();
    }

    @Override
    public void showDialogToRemove(Contacts contacts){

        this.view.showDialogToRemove(contacts);
    }

    @Override
    public void deleteContact(Contacts contacts){

        this.welcomeViewModel.removeContact(contacts);
    }

    @Override
    public void openCountryListView(WelcomeActivity welcomeActivity){
        Intent intent = new Intent(welcomeActivity, CountryListViewActivity.class);
        welcomeActivity.startActivity(intent);
        welcomeActivity.finish();
    }
}

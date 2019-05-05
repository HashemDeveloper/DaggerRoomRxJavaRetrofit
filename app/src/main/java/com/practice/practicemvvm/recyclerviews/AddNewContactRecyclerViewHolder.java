package com.practice.practicemvvm.recyclerviews;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.practice.practicemvvm.R;
import com.practice.practicemvvm.data.room.entities.Contacts;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddNewContactRecyclerViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.welcome_add_contact_name_view_id)
    AppCompatTextView nameView;

    @BindView(R.id.welcome_add_contact_email_view_id)
    AppCompatTextView emailView;

    @BindView(R.id.welcome_add_contact_list_card_view_id)
    MaterialCardView cardView;

    private ViewDataBinding viewDataBinding; // will deal later on!

    AddNewContactRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

//    AddNewContactRecyclerViewHolder(ViewDataBinding viewDataBinding){
//
//        super(viewDataBinding.getRoot());
//        this.viewDataBinding = viewDataBinding;
//    }

    void bindView(Contacts contacts){

        String name = "";
        String email = "";

        if(contacts.getName() != null){

            name = contacts.getName();
        }

        if(contacts.getEmail() != null){

            email = contacts.getEmail();
        }

        if(name != null && !name.isEmpty()){

            this.nameView.setText(name);
        }

        if(email != null && !email.isEmpty()){

            this.emailView.setText(email);
        }
    }

    MaterialCardView getCardView() {
        return cardView;
    }
}

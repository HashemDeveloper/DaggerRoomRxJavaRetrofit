package com.practice.practicemvvm.recyclerviews;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.practice.practicemvvm.R;
import com.practice.practicemvvm.data.room.entities.Contacts;

import java.util.ArrayList;
import java.util.List;

public class AddNewContactRecyclerViewAdapter extends RecyclerView.Adapter {

    private List<Contacts> listOfContacts;

    private ContactClickListener contactClickListener;

    public AddNewContactRecyclerViewAdapter(ContactClickListener contactClickListener){

        this.contactClickListener = contactClickListener;

        this.listOfContacts = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.welcome_add_new_contact_recycler_item_layout, parent, false);

        final AddNewContactRecyclerViewHolder addNewContactRecyclerViewHolder = new AddNewContactRecyclerViewHolder(view);


        addNewContactRecyclerViewHolder.getCardView().setOnClickListener(v -> {

//                if(v.getId() == addNewContactRecyclerViewHolder.getCardView().getId()){
//
//                    Contacts contacts = (Contacts) addNewContactRecyclerViewHolder.itemView.getTag();
//                    contactClickListener.onContactClicked(contacts);
//                }

            viewContactDetails(addNewContactRecyclerViewHolder.getAdapterPosition());
        });

        return addNewContactRecyclerViewHolder;
    }

    private void viewContactDetails(int position){

        Contacts contacts = this.listOfContacts.get(position);
        this.contactClickListener.onContactClicked(contacts);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ((AddNewContactRecyclerViewHolder) holder).bindView(this.listOfContacts.get(position));
    }

    @Override
    public int getItemCount() {
        return this.listOfContacts.size();
    }

    public void setListOfContacts(List<Contacts> contacts){

        if(contacts != null){

            DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new ContactDiffUtilsCallBack(this.listOfContacts, contacts));
            this.listOfContacts.clear();
            this.listOfContacts.addAll(contacts);
            diffResult.dispatchUpdatesTo(this);

        }else{

            this.listOfContacts.clear();
            notifyDataSetChanged();
        }

    }

    public interface ContactClickListener{

        void onContactClicked(Contacts contacts);
    }
}


package com.practice.practicemvvm.activities.welcome;

import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.practice.practicemvvm.data.room.dao.ContactDao;
import com.practice.practicemvvm.data.room.entities.Contacts;

import java.util.List;

import javax.inject.Inject;

public class WelcomeViewModel extends ViewModel {

    private MutableLiveData<Contacts> contactsMutableLiveData = new MutableLiveData<>();

    @NonNull
    private ContactDao contactDao;

    private int clickCounter = 0;

    // Using the LiveData to observe click counter
    private final MutableLiveData<Integer> clickCounterLiveData = new MutableLiveData<>();


    @Inject
    WelcomeViewModel(@NonNull ContactDao contactDao){

        this.contactDao = contactDao;
    }


    MutableLiveData<Integer> getInitialCounter(){

        this.clickCounterLiveData.setValue(this.clickCounter);

        return this.clickCounterLiveData;
    }

    void getCurrentCounter(){

        this.clickCounter += 1;

        this.clickCounterLiveData.setValue(this.clickCounter);
    }

    void processData(String name, String email) {

        Contacts contacts = new Contacts(0, name, email);

        final AddContactAsyncTask addContactAsyncTask = new AddContactAsyncTask(this.contactDao);
        addContactAsyncTask.execute(contacts);
    }

    LiveData<List<Contacts>> getAllContactList() {

        return this.contactDao.getContacts();
    }

    void removeContact(Contacts contacts) {

        final DeleteContactsAsyncTask deleteContactsAsyncTask = new DeleteContactsAsyncTask(this.contactDao);
        deleteContactsAsyncTask.execute(contacts);
    }

    private static class AddContactAsyncTask extends AsyncTask<Contacts, Void, Void>{


        private ContactDao contactDao;

        AddContactAsyncTask(ContactDao contactDao){

            this.contactDao = contactDao;
        }


        @Override
        protected Void doInBackground(Contacts... contacts) {

            this.contactDao.addContact(contacts[0]);

            return null;
        }

    }

    private static class DeleteContactsAsyncTask extends AsyncTask<Contacts, Void, Void>{


        private ContactDao contactDao;

        DeleteContactsAsyncTask(ContactDao contactDao){

            this.contactDao = contactDao;
        }

        @Override
        protected Void doInBackground(Contacts... contacts) {

            this.contactDao.deleteContact(contacts[0]);

            return null;
        }
    }
}

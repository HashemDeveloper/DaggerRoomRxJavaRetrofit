package com.practice.practicemvvm.data.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.practice.practicemvvm.data.room.entities.Contacts;

import java.util.List;

@Dao
public interface ContactDao {

    @Insert
    Long addContact(Contacts contacts);

    @Update
    void updateContact(Contacts contacts);

    @Delete
    public void deleteContact(Contacts contacts);

    @Query("select * from contacts")
    LiveData<List<Contacts>> getContacts();

    @Query("select * from contacts where contact_id =:contactId")
    Contacts getContactsById(Long contactId);

}

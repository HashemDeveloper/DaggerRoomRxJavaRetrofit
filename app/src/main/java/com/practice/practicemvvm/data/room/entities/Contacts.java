package com.practice.practicemvvm.data.room.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "contacts")
public class Contacts {

    @ColumnInfo(name = "contact_name")
    private String name;

    @ColumnInfo(name = "contact_email")
    private String email;

    // this is our primary key
    // when new data added room returns this primary
    // therefore when adding new row to the table so return type of @Insert method should be long too
    // check {@link ContactDao} addContactMethod
    @ColumnInfo(name = "contact_id")
    @PrimaryKey(autoGenerate = true) // this is going to increment the id automatically
    private long id;

    @Ignore // tells room database not to use this constructor
    public Contacts(){


    }

    public Contacts(long id, String name, String email){

        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

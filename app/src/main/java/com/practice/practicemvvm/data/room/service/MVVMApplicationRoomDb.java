package com.practice.practicemvvm.data.room.service;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.practice.practicemvvm.data.room.dao.ContactDao;
import com.practice.practicemvvm.data.room.entities.Contacts;

@Database(entities = {Contacts.class}, version = 1, exportSchema = false)
public abstract class MVVMApplicationRoomDb extends RoomDatabase {

    private static final String DATABASE_FILE_NAME = "com.mvvmapplication.database";

    private static volatile MVVMApplicationRoomDb instance;

    public abstract ContactDao getContactDao();

    static MVVMApplicationRoomDb getInstance(Context context){

        if(instance == null){

            synchronized (MVVMApplicationRoomDb.class){

                if(instance == null){

                    instance = Room.databaseBuilder(context, MVVMApplicationRoomDb.class, DATABASE_FILE_NAME).build();
                }
            }
        }

        return instance;
    }
}

package com.practice.practicemvvm.data.room.service;

import android.content.Context;

import com.practice.practicemvvm.data.room.dao.ContactDao;

public class MVVMApplicationDbService {

    private MVVMApplicationRoomDb mvvmApplicationRoomDb;


    public MVVMApplicationDbService(Context context){

        this.mvvmApplicationRoomDb = MVVMApplicationRoomDb.getInstance(context);
    }

    public ContactDao getContactDao(){

        return this.mvvmApplicationRoomDb.getContactDao();
    }
}

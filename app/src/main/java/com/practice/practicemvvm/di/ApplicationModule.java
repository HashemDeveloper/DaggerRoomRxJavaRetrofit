package com.practice.practicemvvm.di;

import android.content.Context;

import com.practice.practicemvvm.MVVMApplication;
import com.practice.practicemvvm.data.room.dao.ContactDao;
import com.practice.practicemvvm.data.room.service.MVVMApplicationDbService;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
class ApplicationModule {

    @Singleton
    @Provides
    Context provideContext(MVVMApplication application){

        return application;
    }

    @Singleton
    @Provides
    MVVMApplicationDbService provideMvvmApplicationDbService(Context context){

        return new MVVMApplicationDbService(context);
    }

    @Singleton
    @Provides
    ContactDao provideContactDao(MVVMApplicationDbService mvvmApplicationDbService){

        return mvvmApplicationDbService.getContactDao();
    }

}

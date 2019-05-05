package com.practice.practicemvvm;

import android.app.Activity;
import android.app.Application;

import com.practice.practicemvvm.di.DaggerApplicationComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class MVVMApplication extends Application implements HasActivityInjector {


    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        DaggerApplicationComponent.builder().buildApplication(this).build().inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {


        return this.dispatchingAndroidInjector;
    }
}

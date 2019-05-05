package com.practice.practicemvvm.di;

import android.app.Activity;

import com.practice.practicemvvm.activities.welcome.WelcomeActivity;
import com.practice.practicemvvm.activities.welcome.WelcomeActivitySubcomponent;
import com.practice.practicemvvm.activities.welcome.countrylist.CountryListSubcomponent;
import com.practice.practicemvvm.activities.welcome.countrylist.CountryListViewActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {
        WelcomeActivitySubcomponent.class,
        CountryListSubcomponent.class
})
abstract class ActivityModule {

    @Binds
    @IntoMap
    @ActivityKey(WelcomeActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> createAndroidInjectorFactoryForWelcomeActivity(WelcomeActivitySubcomponent.Builder builder);

    @Binds
    @IntoMap
    @ActivityKey(CountryListViewActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> createAndroidInjectorFactoryForCountryListActivity(CountryListSubcomponent.Builder builder);

}

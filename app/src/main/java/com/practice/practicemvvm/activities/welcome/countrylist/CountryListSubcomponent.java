package com.practice.practicemvvm.activities.welcome.countrylist;

import com.practice.practicemvvm.di.scopes.ActivityScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ActivityScope
@Subcomponent(modules = {
        CountryListModule.class
})
public interface CountryListSubcomponent extends AndroidInjector<CountryListViewActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<CountryListViewActivity>{

    }
}

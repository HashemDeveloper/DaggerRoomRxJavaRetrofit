package com.practice.practicemvvm.activities.welcome.countrylist;

import com.practice.practicemvvm.di.scopes.ActivityScope;

import dagger.Binds;
import dagger.Module;

@Module
abstract class CountryListModule {

    @Binds
    @ActivityScope
    abstract CountryListContract.View bindCountryListViewWith(CountryListViewActivity countryListViewActivity);

    @Binds
    @ActivityScope
    abstract CountryListContract.Presenter bindCountryListPresenterWith(CountryListPresenter presenter);
}

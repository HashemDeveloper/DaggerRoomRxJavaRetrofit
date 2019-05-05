package com.practice.practicemvvm.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.practice.practicemvvm.activities.welcome.WelcomeViewModel;
import com.practice.practicemvvm.activities.welcome.countrylist.CountryListViewModel;
import com.practice.practicemvvm.viewmodel.scopes.ViewModelKey;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

//    /** WelcomeViewModel setup Starts**/
//
//    @Provides
//    WelcomeActivityViewModelFactory provideViewModelFactory(Provider<WelcomeViewModel> providerMap) {
//
//        return new WelcomeActivityViewModelFactory(providerMap);
//    }
//
//    @Provides
//    @IntoMap
//    @ViewModelKey(WelcomeViewModel.class)
//    ViewModel bindViewModel(WelcomeViewModel welcomeViewModel){
//
//        return welcomeViewModel;
//    }
//    /** WelcomeViewModel setup Starts**/
//
//    /** Country List View Model Factory Start**/
//    @Provides
//    CountryListViewModelFactory provideCountryListModelFactory(Provider<CountryListViewModel> provideMap){
//
//        return new CountryListViewModelFactory(provideMap);
//    }
//
//    @Provides
//    @IntoMap
//    @ViewModelKey(CountryListViewModel.class)
//    ViewModel bindCountryListViewModel(CountryListViewModel countryListViewModel){
//
//        return countryListViewModel;
//    }
//    /** Country List View Model Factory Ends**/

    @Binds
    @IntoMap
    @ViewModelKey(WelcomeViewModel.class)
    abstract ViewModel bindWelcomeViewModel(WelcomeViewModel welcomeViewModel);


    @Binds
    @IntoMap
    @ViewModelKey(CountryListViewModel.class)
    abstract ViewModel bindCountryListViewModel(CountryListViewModel countryListViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory viewModelFactory);
}

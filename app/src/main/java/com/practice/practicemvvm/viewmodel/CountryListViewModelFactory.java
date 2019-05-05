package com.practice.practicemvvm.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import com.practice.practicemvvm.activities.welcome.countrylist.CountryListViewModel;
import com.practice.practicemvvm.viewmodel.base.BaseViewModelFactory;

import javax.inject.Provider;

public class CountryListViewModelFactory extends BaseViewModelFactory<CountryListViewModel> {

    private Provider<CountryListViewModel> modelProvider;

    public CountryListViewModelFactory(Provider<CountryListViewModel> mViewProvider) {
        super(mViewProvider);
        this.modelProvider = mViewProvider;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        ViewModel viewModel;

        if(modelClass == CountryListViewModel.class){

            viewModel = this.modelProvider.get();

        }else{

            throw new RuntimeException("Unsupported View model: " + modelClass);
        }

        //noinspection unchecked
        return (T) viewModel;
    }
}

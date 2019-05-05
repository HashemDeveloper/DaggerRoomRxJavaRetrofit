package com.practice.practicemvvm.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import com.practice.practicemvvm.activities.welcome.WelcomeViewModel;
import com.practice.practicemvvm.viewmodel.base.BaseViewModelFactory;

import javax.inject.Provider;

public class WelcomeActivityViewModelFactory extends BaseViewModelFactory<WelcomeViewModel> {

    private final Provider<WelcomeViewModel> viewModelProvider;

    WelcomeActivityViewModelFactory(Provider<WelcomeViewModel> viewModelProvider){
        super(viewModelProvider);
        this.viewModelProvider = viewModelProvider;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

       ViewModel viewModel;

       if(modelClass == WelcomeViewModel.class){

           viewModel = this.viewModelProvider.get();

       }else{

           throw new RuntimeException("Unsupported View model: " + modelClass);
       }

       return (T) viewModel;
    }
}

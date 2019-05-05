package com.practice.practicemvvm.viewmodel.base;

import androidx.lifecycle.ViewModelProvider;

import javax.inject.Provider;

public abstract class BaseViewModelFactory<T> implements ViewModelProvider.Factory {

    private final Provider<T> mViewProvider;

    public BaseViewModelFactory(Provider<T> mViewProvider){

        this.mViewProvider = mViewProvider;
    }
}

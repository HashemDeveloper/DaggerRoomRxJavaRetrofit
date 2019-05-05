package com.practice.practicemvvm.activities.welcome.countrylist;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;

import com.practice.practicemvvm.viewmodel.ViewModelFactory;

import javax.inject.Inject;

public class CountryListPresenter implements CountryListContract.Presenter{

    @NonNull
    private CountryListContract.View view;
    @NonNull
    private ViewModelFactory viewModelFactory;
    private CountryListViewModel countryListViewModel;

    @Inject
    public CountryListPresenter(@NonNull CountryListContract.View view, @NonNull ViewModelFactory viewModelFactory){
        this.view = view;
        this.viewModelFactory = viewModelFactory;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {

    }

    @Override
    public void attachViewModel(FragmentActivity activity) {
        this.countryListViewModel = ViewModelProviders.of(activity, this.viewModelFactory).get(CountryListViewModel.class);
    }

    @Override
    public void processCountryListData(CountryListViewActivity countryListViewActivity) {
        this.countryListViewModel.getCountryInfoMutableLiveData().observe(countryListViewActivity, countryInfo -> view.showCountryList(countryInfo));
        this.countryListViewModel.getIsLoading().observe(countryListViewActivity, aBoolean -> view.showProgressBar(aBoolean));
        this.countryListViewModel.getIsError().observe(countryListViewActivity, aBoolean -> view.showError(aBoolean));
    }
}

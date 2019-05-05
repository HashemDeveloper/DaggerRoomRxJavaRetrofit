package com.practice.practicemvvm.activities.welcome.countrylist;

import androidx.fragment.app.FragmentActivity;

import com.practice.practicemvvm.base.IBaseActivity;
import com.practice.practicemvvm.base.IBasePresenter;
import com.practice.practicemvvm.model.CountryInfo;

public interface CountryListContract {

    interface View extends IBaseActivity{
        void showCountryList(CountryInfo countryInfo);

        void showProgressBar(Boolean aBoolean);

        void showError(Boolean aBoolean);
    }

    interface Presenter extends IBasePresenter{

        void attachViewModel(FragmentActivity activity);

        void processCountryListData(CountryListViewActivity countryListViewActivity);
    }
}

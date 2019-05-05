package com.practice.practicemvvm.activities.welcome;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;

import com.google.android.material.textfield.TextInputLayout;
import com.practice.practicemvvm.base.IBaseActivity;
import com.practice.practicemvvm.base.IBasePresenter;
import com.practice.practicemvvm.data.room.entities.Contacts;

import java.util.List;

public interface WelcomeActivityContract {

    interface View extends IBaseActivity{

        void observeLiveData(LiveData<Integer> integerLiveData);

        void displayAddNewContactCard();

        void getUserInputs();

        void dispatchLiveData(LiveData<List<Contacts>> contactsLiveData);

        void showDialogToRemove(Contacts contacts);
    }

    interface Presenter extends IBasePresenter{

        void showCurrentValue();

        void attachViewModel(FragmentActivity activity);

        void displayAddNewContactCard();

        void setUpEmailValidator(TextInputLayout addEmailInputLayout);

        void getUserInputs();

        boolean validateEmail(String email);

        void processData(String name, String email);

        LiveData<List<Contacts>> getLiveContactData();

        void showDialogToRemove(Contacts contacts);

        void deleteContact(Contacts contacts);

        void openCountryListView(WelcomeActivity welcomeActivity);
    }
}

package com.practice.practicemvvm.activities.welcome;

import com.practice.practicemvvm.di.scopes.ActivityScope;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class WelcomeActivityModule {

    @Binds
    @ActivityScope
    abstract WelcomeActivityContract.View bindIViewWith(WelcomeActivity welcomeActivity);

    @Binds
    @ActivityScope
    abstract WelcomeActivityContract.Presenter bindIPresenterWith(WelcomeActivityPresenter presenter);
}

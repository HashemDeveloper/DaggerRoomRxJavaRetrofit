package com.practice.practicemvvm.activities.welcome;

import com.practice.practicemvvm.di.scopes.ActivityScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ActivityScope
@Subcomponent(modules = {

        WelcomeActivityModule.class
})
public interface WelcomeActivitySubcomponent extends AndroidInjector<WelcomeActivity>{

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<WelcomeActivity>{

    }
}

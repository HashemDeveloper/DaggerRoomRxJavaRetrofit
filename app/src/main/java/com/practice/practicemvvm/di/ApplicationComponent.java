package com.practice.practicemvvm.di;

import com.practice.practicemvvm.MVVMApplication;
import com.practice.practicemvvm.data.remote.GetCountryDataServiceModule;
import com.practice.practicemvvm.viewmodel.ViewModelModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        AndroidInjectionModule.class,
        ActivityModule.class,
        ViewModelModule.class,
        ServiceModule.class,
        GetCountryDataServiceModule.class
})
public interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder buildApplication(MVVMApplication application);

        ApplicationComponent build();

    }

    void inject(MVVMApplication application);
}

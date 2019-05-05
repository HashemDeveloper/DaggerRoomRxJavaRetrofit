package com.practice.practicemvvm.data.remote;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public abstract class GetCountryDataServiceModule {

    @Provides
    @Singleton
    static GetCountryDataService provideGetCountryDataService(Retrofit retrofit){

        return retrofit.create(GetCountryDataService.class);
    }
}

package com.practice.practicemvvm.di;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Call;
import okhttp3.OkHttpClient;

@Module
abstract class NetworkingModule {

    @Provides
    @Singleton
    static Call.Factory provideOkHttp(){
        return new OkHttpClient.Builder()
                .build();
    }

    @Provides
    @Named("base_url")
    static String provideBaseUrl(){
        return "http://services.groupkt.com/";
    }
}

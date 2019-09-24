package com.smirk.revoluttest.di

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.mylab.shap.utils.LiveDataCallAdapterFactory
import com.smirk.revoluttest.api.ApiService
import com.smirk.revoluttest.api.BASE_URL
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Tony Augustine on 09,September,2019
 * tonyaugustine47@gmail.com
 */
@Module(includes = [OkHttpClientModule::class])
class RetrofitModule {

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        httpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory,
        liveDataAdapterFactory: LiveDataCallAdapterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(liveDataAdapterFactory)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideLiveDataAdapterFactory(): LiveDataCallAdapterFactory {
        return LiveDataCallAdapterFactory()
    }

    @Singleton
    @Provides
    fun provideGsonConvertorFactoty(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

}
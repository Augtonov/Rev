package com.smirk.revoluttest.di

import android.app.Application
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber
import java.io.File
import javax.inject.Singleton

/**
 * Created by Tony Augustine on 09,September,2019
 * tonyaugustine47@gmail.com
 */
@Module
class OkHttpClientModule {

    @Singleton
    @Provides
    fun provideHttpLogginInterCeptor(): HttpLoggingInterceptor {
        /*val httpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { data ->
            Timber.d(data)
        })*/
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @Singleton
    @Provides
    fun provideCache(cacheFile: File): Cache {
        return Cache(cacheFile, 10 * 1000 * 1000)
    }

    @Singleton
    @Provides
    fun provideCacheFile(context: Application): File {
        val file = File(context.cacheDir, "HttpCache")
        file.mkdir()
        return file
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(cache: Cache, httpLoginInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient()
            .newBuilder()
//            .cache(cache)
            .addInterceptor(httpLoginInterceptor)
            .build()
    }





    /*@Singleton
    @Provides
    fun provideAuthenticationInterceptor(): AuthenticationInterceptor {
        return AuthenticationInterceptor()
    }*/
}
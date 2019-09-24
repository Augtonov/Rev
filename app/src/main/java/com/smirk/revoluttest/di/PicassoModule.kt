package com.smirk.revoluttest.di

import android.app.Application
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton

/**
 * Created by Tony Augustine on 09,September,2019
 * tonyaugustine47@gmail.com
 */
@Module(includes = [OkHttpClientModule :: class])
class PicassoModule {

    @Singleton
    @Provides
    fun providePiccaso(context : Application, okhttp3Downloader : OkHttp3Downloader) : Picasso {
        return Picasso.Builder(context)
            .downloader(okhttp3Downloader)
            .build()
    }

    @Singleton
    @Provides
    fun provideOkHttp3Downloader(okhttpClient : OkHttpClient) : OkHttp3Downloader {
        return OkHttp3Downloader(okhttpClient)
    }
}
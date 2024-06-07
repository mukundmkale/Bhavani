package com.mukund.mvvmcodearchitecture.api

import com.mukund.mvvmcodearchitecture.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.OkHttpClient.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RetrofitClientProvider {

    @Provides
    @Singleton
    fun providesRetrofitBuilder(clint:OkHttpClient): Retrofit =
        Retrofit.Builder()
            .client(clint)
            .baseUrl(BuildConfig.BASE_URL)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    fun providesApiService(retrofit: Retrofit):ApiService =
        retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun providesOkHttpClient():OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
interceptor.level=HttpLoggingInterceptor.Level.BODY
       return Builder()
             .addInterceptor(interceptor)
           .addInterceptor(TokenInterceptor())
            .readTimeout(90, TimeUnit.SECONDS)
            .connectTimeout(90, TimeUnit.SECONDS)
            .build()

    }

}
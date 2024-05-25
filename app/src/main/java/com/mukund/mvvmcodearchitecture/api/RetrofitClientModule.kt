package com.mukund.mvvmcodearchitecture.api

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.OkHttpClient.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitClientModule {

    @Provides
    @Singleton
    fun providesRetrofitBuilder(clint:OkHttpClient): Retrofit =
        Retrofit.Builder()
            .client(clint)
            .baseUrl("")
           // .addCallAdapterFactory()
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
            .readTimeout(90, TimeUnit.SECONDS)
            .connectTimeout(90, TimeUnit.SECONDS)
            .build()

    }

}
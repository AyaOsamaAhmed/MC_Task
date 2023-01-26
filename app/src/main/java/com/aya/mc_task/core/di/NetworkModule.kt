package com.aya.mc_task.core.di

import com.aya.mc_task.BuildConfig
import com.aya.mc_task.core.network.*
import com.aya.mc_task.core.response.NetworkResponseAdapterFactory
import com.aya.mc_task.utils.Constants.BASE_URL_API
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AuthInterceptorOkHttpClient

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Singleton
    @Provides
    fun provideAuthRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_API)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .build()
    }


    @Singleton
    @Provides
    fun provideMainApiService(retrofit: Retrofit): MainApis = retrofit.create(MainApis::class.java)


    @AuthInterceptorOkHttpClient
    @Singleton
    @Provides
    fun provideAuthInterceptor( ): AuthInterceptor
        = AuthInterceptor( )

    @Singleton
    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        @AuthInterceptorOkHttpClient authInterceptor: AuthInterceptor,
    ): OkHttpClient {
        val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        okHttpClientBuilder.addInterceptor(authInterceptor)
        if (BuildConfig.DEBUG) {
            okHttpClientBuilder.addInterceptor(loggingInterceptor)
        }
        return okHttpClientBuilder.build()
    }

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
}
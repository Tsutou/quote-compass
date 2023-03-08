package com.geisha.quote_compass.di

import com.geisha.quote_compass.data.api.service.ChatGPTApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @ChatGptHttpClient
    @Singleton
    @Provides
    fun provideOkHttpClient() : OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(240, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideGptApiService(
        @ChatGptHttpClient client: OkHttpClient,
        loggingInterceptor: HttpLoggingInterceptor,
        retrofitBuilder: Retrofit.Builder,
    ): ChatGPTApiService {
        return retrofitBuilder
            .baseUrl("https://api.openai.com/v1/")
            .client(client.newBuilder().addInterceptor(loggingInterceptor).build())
            .build()
            .create(ChatGPTApiService::class.java)
    }

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class ChatGptHttpClient
}
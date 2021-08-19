package com.user.profileevalution.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class Client {
    companion object{
        var retrofit: Retrofit? = null

        fun getClient(url: String?, timeout: Long): Retrofit? {
            retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create()) //.addConverterFactory(ScalarsConverterFactory.create())
                .client(
                    OkHttpClient().newBuilder()
                        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                        .readTimeout(timeout, TimeUnit.SECONDS)
                        .writeTimeout(timeout, TimeUnit.SECONDS)
                        .connectTimeout(timeout, TimeUnit.SECONDS)
                        .build()
                )
                .build()
            return retrofit
        }
    }
}
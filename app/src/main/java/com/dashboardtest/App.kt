package com.dashboardtest

import android.app.Application
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App: Application() {
    override fun onCreate() {
        super.onCreate()
    }

    private fun configureRetrofit() {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        val retrofit = Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://sandbox.skill-branch.ru/dashboards/grade")
            .build()
    }
}
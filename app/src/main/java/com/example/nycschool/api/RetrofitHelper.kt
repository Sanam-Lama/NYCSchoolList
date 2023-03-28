package com.example.nycschool.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * It is a helper class where we create an instance of Retrofit, a third party library that
 * helps us to simplify our network calls.
 * We define the base url and use the retrofit object created here to call the apis through repository
 */

object RetrofitHelper {
    private val BASE_URL = "https://data.cityofnewyork.us/"

    var gson = GsonBuilder()
        .setLenient()
        .create()

    fun getInstance() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

//    fun getSchoolApi(retrofit: Retrofit): SchoolService {
//        return retrofit.create(SchoolService::class.java)
//    }
}
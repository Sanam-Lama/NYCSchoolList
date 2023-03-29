package com.example.nycschool.di

import com.example.nycschool.api.SchoolService
import com.example.nycschool.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    /**
     * @Singleton: this annotation will create only one object of the retrofit throughout the application
     * @Provides: is used to tell Dagger how to provide classes that our project doesn't own
     */

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesSchoolApi(retrofit: Retrofit): SchoolService {
        return retrofit.create(SchoolService::class.java)
    }
}
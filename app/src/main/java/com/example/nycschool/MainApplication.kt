package com.example.nycschool

import android.app.Application
import com.example.nycschool.di.ApplicationComponent
import com.example.nycschool.di.DaggerApplicationComponent

class MainApplication: Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        //initialize component
        applicationComponent = DaggerApplicationComponent.builder().build()
    }
}
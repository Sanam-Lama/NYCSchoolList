package com.example.nycschool.di

import com.example.nycschool.ui.fragments.SchoolFragment
import dagger.Component
import javax.inject.Singleton

/**
 * NetworkModule has a scoped objects therefore, we need to annotate our component with @Singleton
 */

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

//    fun inject(mainActivity: MainActivity)
    fun inject(schoolFragment: SchoolFragment)
}
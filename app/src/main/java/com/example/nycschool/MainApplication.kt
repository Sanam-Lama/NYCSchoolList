package com.example.nycschool

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * We need to create main application(any name is fine) whenever we are using hilt.
 * this class is the beginning point for hilt where all the dependency injection code
 * starts.
 *
 * We need to add it in manifest file
 */

@HiltAndroidApp
class MainApplication: Application() {
}
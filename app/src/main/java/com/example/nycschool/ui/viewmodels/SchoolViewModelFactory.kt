package com.example.nycschool.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nycschool.repository.SchoolRepository

/**
 * Whenever we have a parameterized ViewModel, we need to create a ViewModelFactory
 */
class SchoolViewModelFactory(private val repository: SchoolRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SchoolViewModel(repository) as T
    }
}
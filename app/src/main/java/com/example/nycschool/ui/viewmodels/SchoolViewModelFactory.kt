package com.example.nycschool.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nycschool.repository.SchoolRepository
import javax.inject.Inject

/**
 * Whenever we have a parameterized ViewModel, we need to create a ViewModelFactory
 */
class SchoolViewModelFactory @Inject constructor(private val repository: SchoolRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SchoolViewModel(repository) as T
    }
}
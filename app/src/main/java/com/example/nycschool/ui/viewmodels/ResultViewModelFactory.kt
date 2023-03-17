package com.example.nycschool.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nycschool.repository.SatResultRepository

class ResultViewModelFactory(private val repository: SatResultRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ResultViewModel(repository) as T
        }
}
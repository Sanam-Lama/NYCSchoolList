package com.example.nycschool.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nycschool.models.SchoolItem
import com.example.nycschool.repository.SchoolRepository
import kotlinx.coroutines.launch

/**
 * We cannot apply a constructor injection here for viewmodel because the object for repository
 * is provided viewmodel factory
 */
class SchoolViewModel(private val schoolRepository: SchoolRepository) : ViewModel() {

    val schoolData: LiveData<List<SchoolItem>>
        get() = schoolRepository.schoolLiveData

    //viewModelScope helps us keep the coroutine alive only until the viewmodel is alive
    fun getSchools() {
        viewModelScope.launch {
            schoolRepository.getSchools()
        }
    }
}
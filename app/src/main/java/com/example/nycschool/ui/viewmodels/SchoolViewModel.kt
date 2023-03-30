package com.example.nycschool.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nycschool.models.SchoolItem
import com.example.nycschool.repository.SchoolRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @HiltViewModel: this annotation will help us to skip the manual creation of view model
 * factory. It will create the factory for us behind the scene
 *
 * @Inject will provide us the object of repository
 */

@HiltViewModel
class SchoolViewModel @Inject constructor(private val schoolRepository: SchoolRepository) : ViewModel() {

    val schoolData: LiveData<List<SchoolItem>>
        get() = schoolRepository.schoolLiveData

    //viewModelScope helps us keep the coroutine alive only until the viewmodel is alive
    fun getSchools() {
        viewModelScope.launch {
            schoolRepository.getSchools()
        }
    }
}
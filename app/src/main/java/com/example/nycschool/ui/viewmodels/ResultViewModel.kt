package com.example.nycschool.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nycschool.models.SatResultsItem
import com.example.nycschool.repository.SatResultRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResultViewModel @Inject constructor(private val satResultRepository: SatResultRepository): ViewModel() {

    val satResults: LiveData<List<SatResultsItem>>
        get() = satResultRepository.satResultLiveData

    fun getSatResults(dbn: String) {
        viewModelScope.launch {
            satResultRepository.getSatResults(dbn)
        }
    }
}
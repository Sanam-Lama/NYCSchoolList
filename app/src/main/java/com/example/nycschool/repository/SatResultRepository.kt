package com.example.nycschool.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nycschool.api.SatResultService
import com.example.nycschool.models.SatResultsItem
import javax.inject.Inject

/**
 * Repository to perform the api call for the satResults
 */
class SatResultRepository @Inject constructor(private val satResultService: SatResultService) {

    private val _satResultLiveData = MutableLiveData<List<SatResultsItem>>()
    val satResultLiveData: LiveData<List<SatResultsItem>>
    get() = _satResultLiveData

    suspend fun getSatResults(dbn: String) {
        val result = satResultService.getSatResults(dbn)
        if (result?.body() != null) {
            _satResultLiveData.postValue(result.body())
        }
    }
}
package com.example.nycschool.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nycschool.api.SchoolService
import com.example.nycschool.models.SchoolItem
import kotlinx.coroutines.delay

/**
 * This is the repository class for this project where we add the methods for network calls.
 * We make use of LiveData and MutableLiveData to help us observe the actual data that is
 * coming from the network.
 *
 * ViewModel will call the methods in here and get the required data from the call
 */

class SchoolRepository(private val schoolService: SchoolService) {

    private val _schoolLiveData = MutableLiveData<List<SchoolItem>>()

    val schoolLiveData: LiveData<List<SchoolItem>>
        get() = _schoolLiveData

//    suspend fun getSchools() {
//        val result = schoolService.getSchools()
//        if (result.body() != null) {
//            _schoolLiveData.postValue(result.body())
//        }
//    }

    suspend fun getSchools(page: Int, pageSize: Int): Result<List<SchoolItem>> {
        delay(2000L)
//        val pageInt = page.toInt()
        val startingIndex = page * pageSize
        return if (startingIndex + pageSize <= remoteDataSource.size) {
            Result.success(
                remoteDataSource.slice(startingIndex until startingIndex + pageSize)
            )
        } else Result.success(emptyList())
    }

    /**
     * we want to paginate 100 items from the api
     */
    private val remoteDataSource = (1..100).map {
        SchoolItem(
            dbn = "DBN $it",
            school_name = "School Name $it"
        )
    }
}
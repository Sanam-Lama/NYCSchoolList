package com.example.nycschool.api

import com.example.nycschool.models.SatResultsItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Service class for calling the endpoints for sat results
 * here, I have used "dbn" as a key to retrieve the data for the
 * selected school
 */
interface SatResultService {

    @GET("resource/f9bf-2cp4.json")
    suspend fun getSatResults(@Query("dbn") dbn: String) : Response<List<SatResultsItem>>
}
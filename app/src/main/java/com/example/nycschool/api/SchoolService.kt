package com.example.nycschool.api

import com.example.nycschool.models.SchoolItem
import retrofit2.Response
import retrofit2.http.GET

/**
 * Interface to define the endpoints
 * we will perform our GET, POST, UPDATE, DELETE operations here and add parameters, headers and body
 * as per the requirement
 *
 * since I was supposed to get the data from the given api call, I used GET method to retrieve the
 * data from the api.
 * https://data.cityofnewyork.us/Education/2017-DOE-High-School-Directory/s3k6-pzi2
*/

interface SchoolService {

    @GET("resource/s3k6-pzi2")
    suspend fun getSchools() : Response<List<SchoolItem>>
}
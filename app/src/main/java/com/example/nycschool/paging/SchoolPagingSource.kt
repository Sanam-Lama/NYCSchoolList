//package com.example.nycschool.paging
//
//import androidx.paging.PagingSource
//import androidx.paging.PagingState
//import com.example.nycschool.api.SchoolService
//import com.example.nycschool.models.SchoolItem
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.withContext
//import retrofit2.HttpException
//import java.io.IOException
//
//class SchoolPagingSource(val schoolApi: SchoolService): PagingSource<String, SchoolItem>() {
//
//    /**
//     *
//     */
//    override fun getRefreshKey(state: PagingState<String, SchoolItem>): String? {
//        TODO("Not yet implemented")
//    }
//
//    /**
//     * this method is used to load the data from the API. It uses String tokens(key)
//     * to load the data
//     */
//    override suspend fun load(params: LoadParams<String>): LoadResult<String, SchoolItem> {
//
//    }
//}
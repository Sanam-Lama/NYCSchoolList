package com.example.nycschool.paging

/**
 * this class will specify what Paginator should be able to do
 */
interface Paginator<Key, School> {
    suspend fun loadNextItems()
    fun reset()
}
package com.example.nycschool.paging


import com.example.nycschool.models.SchoolItem

/**
 * Concrete class that will implement the interface Paginator
 *
 * inline =?
 */
class DefaultPaginator<Key, SchoolItem>(
    private val initialKey: Key,            //it will provide the first page of the api

    //lamda callback when the loading value is updated, either loading new items or have finished the loading items
    private inline val onLoadUpdated: (Boolean) -> Unit,

    //this function will define how we will get the next load of items given the key, with returning value of the items(model)
    private inline val onRequest: suspend (nextKey: Key) -> Result<List<SchoolItem>>,

    //this will provide the next key that can be used to load the next bunch of items
    private inline val getNextKey: suspend (List<SchoolItem>) -> Key,

    //if we get any error then this function will handle it, it doen't return anything
    private inline val onError: suspend (Throwable?) -> Unit,

    //it will give us the list of items and the new key to load
    private inline val onSuccess: suspend (items: List<SchoolItem>, newKey: Key) -> Unit
): Paginator<Key, SchoolItem> {

    private var currentKey = initialKey
    private var isMakingRequest = false

    override suspend fun loadNextItems() {
        if (isMakingRequest) {
            return
        }
        isMakingRequest = true
        onLoadUpdated(true)
        val result = onRequest(currentKey)
        isMakingRequest = false

        //it will return list of items if api call (result) is successful, else will throw an error and return
        val items = result.getOrElse {
            onError(it)
            onLoadUpdated(false)
            return
        }
        //if it reaches here then it means, result is successful
        currentKey = getNextKey(items)
        onSuccess(items, currentKey)
        onLoadUpdated(false)
    }

    override fun reset() {
        currentKey = initialKey
    }

}
package com.example.nycschool.ui.viewmodels

import androidx.compose.runtime.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nycschool.models.SchoolItem
import com.example.nycschool.paging.DefaultPaginator
import com.example.nycschool.repository.SchoolRepository
import kotlinx.coroutines.launch

class SchoolViewModel(private val schoolRepository: SchoolRepository) : ViewModel() {

    val schoolData: LiveData<List<SchoolItem>>
        get() = schoolRepository.schoolLiveData

    //viewModelScope helps us keep the coroutine alive only until the viewmodel is alive
    fun getSchools(page: Int, pageSize: Int) {
        viewModelScope.launch {
            schoolRepository.getSchools(page, pageSize)
        }
    }

    var state by mutableStateOf(ScreenState())

    private val paginator = DefaultPaginator<_, SchoolItem>(
        initialKey = state.page,
        onLoadUpdated = {
            state = state.copy(isLoading = it)
        },
        onRequest = {
            schoolRepository.getSchools(it, 20)
        },
        getNextKey = {
            state.page + 1
        },
        onError = {
            state = state.copy(error = it?.localizedMessage)
        },
        onSuccess = { items, newKey ->
            state = state.copy(
                items = state.items + items,
                page = newKey,
                endReached = items.isEmpty()    //end of list is reached if the list is empty
            )
        }
    )

    //we want to load "loadNextItems()" function at the very beginning so we add it in init block
    init {
        loadNextItems()
    }

    private fun loadNextItems() {
        viewModelScope.launch {
            paginator.loadNextItems()
        }
    }
}

/**
 * describes the current state of our current pagination
 */
data class ScreenState(
    val isLoading: Boolean = false,
    val items: List<SchoolItem> = emptyList(),
    val error: String? = null,
    val endReached: Boolean = false,
    val page: Int = 0
)
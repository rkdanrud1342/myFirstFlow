package com.example.myFlow.main.viewModel

import androidx.lifecycle.*
import com.example.myFlow.MyFirstRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.catch

import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MainViewModel(private val repo: MyFirstRepository): ViewModel() {

    private lateinit var driverPointAmount: LiveData<Long>

    @ExperimentalCoroutinesApi
    private val driverPointAmountFromCallbackFlow: LiveData<Long> = repo.driverPointDataSource.driverPointAmountCallbackFlow

    init {
        viewModelScope.launch {
            driverPointAmount = repo.driverPointAmount
                .flowOn(Dispatchers.IO)
                .map { it.pointAmount }
                .flowOn(Dispatchers.Default)
                .catch { e -> e.printStackTrace() }
                .asLiveData()
        }
    }
}
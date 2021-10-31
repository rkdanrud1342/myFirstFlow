package com.example.myFlow.main.model

import androidx.lifecycle.asLiveData
import com.example.myFlow.util.asCallbackFLow
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class DriverPointDataSource(
    private val mainApi: MainApi,
    private val refreshIntervalMs: Long = 5000
) {
    val latestDriverPointAmount: Flow<DriverPointAmount> = flow {
        while(true) {
            val latestDriverPointAmount = mainApi.getDriverPoint()
            emit(latestDriverPointAmount)
            delay(refreshIntervalMs)
        }
    }

    @ExperimentalCoroutinesApi
    val driverPointAmountCallbackFlow = mainApi.getDriverPointAsCallback().asCallbackFLow()
            .catch { e -> e.printStackTrace() }
            .flowOn(Dispatchers.IO)
            .map { it.pointAmount }
            .flowOn(Dispatchers.Default)
            .asLiveData()
}
package com.example.myFlow.util

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@ExperimentalCoroutinesApi
fun <T> Call<T>.asCallbackFLow() = callbackFlow<T> {
    enqueue(object : Callback<T> {
        // 응답을 받은경우의 호출
        override fun onResponse(call: Call<T>, response: Response<T>) {
            if (response.isSuccessful) {
                response.body()?.let { trySend(it) } ?: close(EmptyBodyError())
            } else {
                close(FailNetworkError("${response.code()} + ${response.errorBody()}"))
            }
        }

        //호출이 실패한 경우
        override fun onFailure(call: Call<T>, throwable: Throwable) {
            close(throwable)
        }
    })

    awaitClose() //close가 호출될때까지 기다립니다.
}

class EmptyBodyError: Exception()

class FailNetworkError(msg: String): Exception(msg)
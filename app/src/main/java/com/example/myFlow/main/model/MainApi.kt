package com.example.myFlow.main.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface MainApi {
    @GET("legacy/object")
    suspend fun getDriverPoint(
        @Header("__et") encrypt: Int = 0,
        @Header("__pr") procedure: String = "wda_Driver_CallMoneyGet2"
    ): DriverPointAmount

    @GET("legacy/object")
    fun getDriverPointAsCallback(
        @Header("__et") encrypt: Int = 0,
        @Header("__pr") procedure: String = "wda_Driver_CallMoneyGet2"
    ): Call<DriverPointAmount>
}
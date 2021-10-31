package com.example.myFlow.main.model

import com.google.gson.annotations.SerializedName

data class DriverPointAmount(
    @SerializedName("point_amount")
    val pointAmount: Long
)

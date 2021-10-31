package com.example.myFlow

import com.example.myFlow.main.model.DriverPointDataSource

class MyFirstRepository(
    val driverPointDataSource: DriverPointDataSource
) {
    val driverPointAmount = driverPointDataSource.latestDriverPointAmount
}
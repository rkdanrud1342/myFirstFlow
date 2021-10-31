package com.example.myFlow.modules

import com.example.myFlow.main.model.DriverPointDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    single { DriverPointDataSource(get()) }
}
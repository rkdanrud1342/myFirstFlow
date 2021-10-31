package com.example.myFlow.modules

import com.example.myFlow.MyFirstRepository
import org.koin.dsl.module

val repoModule = module {
    single { MyFirstRepository(get()) }
}
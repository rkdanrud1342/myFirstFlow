package com.example.myFlow.modules

import com.example.myFlow.main.model.MainApi
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single(createdAtStart = false) {
        get<Retrofit>().create(MainApi::class.java)
    }
}
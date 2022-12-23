package com.example.koinpractice

import org.koin.dsl.module
/*
Koin MyModule
*/
val myModule = module{
    single {AA()}
    factory {BB(get())}
}
package com.example.koinpractice

import org.koin.dsl.module
/*
Koin MyModule
*/
val myModule = module{
    single {AA()}
    factory {BB(get())}
}

class ComponentA()
class ComponentB(val componentA: ComponentA)

val moduleA = module {
    single{ComponentA()}
}

val moduleB = module{
    single{ComponentB(get())}
}
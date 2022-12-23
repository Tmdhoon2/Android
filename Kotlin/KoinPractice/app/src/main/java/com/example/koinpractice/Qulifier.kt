package com.example.koinpractice

import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.koin.android.ext.android.get

// StringQulifier
class A

val module = module {
    scope(named("my_scope")) {
        scoped { A() }
    }
}

// TypeQulifier
class B
class C

val module2 = module {
    factory { A() }

    scope(named<A>()) {
        scoped { B() }
        scoped { C() }
    }

    scope<A> {
        scoped { B() }
        scoped { C() }
    }
}
package com.example.koinpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.koin.android.ext.android.get
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named
import org.koin.dsl.module

class MainActivity : AppCompatActivity() {

    // inject() 의존성 주입 - Lazy
    val bb_inject1: BB by inject()     // Type by inject()
    val bb_inject2 by inject<BB>()      // by inject<Type>()

    // get() 의존성 주입 - 바로 주입 방식
    var bb_get1: BB = get()            // Type = get()
    var bb_get2 = get<BB>()             // get<Type>()

    val myScope = getKoin().getOrCreateScope("id", named("my_scope"))

    val a = myScope.get<A>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("bb_inject1 name is ${bb_inject1.name()}")
        println("bb_inject2 name is ${bb_inject2.name()}")

        println("bb_get1 name is ${bb_get1.name()}")
        println("bb_get2 name is ${bb_get2.name()}")
    }
}

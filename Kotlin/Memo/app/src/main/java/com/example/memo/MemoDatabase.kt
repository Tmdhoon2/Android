package com.example.memo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(MemoEntity::class), version = 1)   // Database 어노테이션으로 관리
abstract class MemoDatabase :RoomDatabase() {                   // abstract == 인터페이스의 역할  + 클래스의 기능
    abstract  fun memoDAO() : MemoDAO                           // 추상 메소드

    companion object {
        var INSTANCE : MemoDatabase? = null

        fun getInstatnce(context: Context) : MemoDatabase? {    // DB 생성 메서드
            if(INSTANCE == null){
                synchronized(MemoDatabase::class){      // synchronized == 스레드 동기화
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                    MemoDatabase::class.java, "memo.db")
                        .fallbackToDestructiveMigration()   // 기존 데이터를 버리고 다음 버전으로 넘어감
                        .build()
                }
            }

            return INSTANCE
        }
    }
}
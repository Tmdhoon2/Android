package com.example.memo

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface MemoDAO {

    @Insert(onConflict = REPLACE)   // 기본키가 겹치면 덮어씌움
    fun insert(memo : MemoEntity)   // insert 함수, MemoEntity의 memo 매개변수

    @Query("SELECT * FROM memo")    // 모든 메모 불러오기
    fun getAll() : List<MemoEntity> // 메모 엔티티를 리스트에 담음

    @Delete                         // 삭제
    fun delete(memo : MemoEntity)   // 메모 엔티티의 메모 삭제

}
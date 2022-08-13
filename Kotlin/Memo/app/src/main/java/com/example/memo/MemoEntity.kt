package com.example.memo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "memo")          // memo 테이블 생성 (릴레이션)
data class MemoEntity(
    @PrimaryKey(autoGenerate = true)    // 기본키 (자동으로 항목에 ID 할당)
    var id : Long?,
    var memo : String
)
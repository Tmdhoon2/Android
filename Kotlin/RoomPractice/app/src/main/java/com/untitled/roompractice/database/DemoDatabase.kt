package com.untitled.roompractice.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.untitled.roompractice.dao.RecruitmentDao
import com.untitled.roompractice.entity.Recruitment

@Database(
    entities = [Recruitment::class],
    version = 1,
)
internal abstract class DemoDatabase : RoomDatabase() {
    abstract fun recruitmentDao(): RecruitmentDao
}
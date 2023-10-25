package com.untitled.roompractice.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.untitled.roompractice.entity.Recruitment

@Dao
internal interface RecruitmentDao {
    @Query("select * from recruitment")
    fun getRecruitments(): List<Recruitment>

    @Query("select * from recruitment where recruitmentId = (:recruitmentId)")
    fun getRecruitmentDetails(recruitmentId: Long): Recruitment

    @Insert
    fun addRecruitment(recruitment: Recruitment)

    @Delete
    fun deleteRecruitment(recruitment: Recruitment)
}
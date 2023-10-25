package com.untitled.roompractice.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
internal data class Recruitment(
    @PrimaryKey val recruitmentId: Long,
    @ColumnInfo("company_name") val companyName: String,
    @ColumnInfo("train_pay") val trainPay: Long,
    val military: Boolean,
)

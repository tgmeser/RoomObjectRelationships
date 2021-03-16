package com.babyapps.roomdbmodels.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Coach(
    @PrimaryKey(autoGenerate = false)
    val coachName: String,
    val coachNation: String,
    val teamName: String
)
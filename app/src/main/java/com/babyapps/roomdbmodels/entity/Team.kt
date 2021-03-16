package com.babyapps.roomdbmodels.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Team(
    @PrimaryKey(autoGenerate = false)
    val teamName: String,
    val teamCountry: String,
)
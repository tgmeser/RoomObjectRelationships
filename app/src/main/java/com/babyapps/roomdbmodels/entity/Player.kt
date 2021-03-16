package com.babyapps.roomdbmodels.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Player(
    @PrimaryKey(autoGenerate = false)
    val playerName: String,
    val age: Int,
    val teamName: String,
    val playerNation: String
)
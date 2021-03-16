package com.babyapps.roomdbmodels.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ChampionShip(
    @PrimaryKey(autoGenerate = false)
    val championShipName: String
)
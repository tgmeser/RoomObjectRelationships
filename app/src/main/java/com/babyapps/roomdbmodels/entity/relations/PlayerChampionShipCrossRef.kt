package com.babyapps.roomdbmodels.entity.relations

import androidx.room.Entity

//  N TO M Relationship
@Entity(primaryKeys = ["playerName", "championShipName"])
data class PlayerChampionShipCrossRef(
    val playerName: String,
    val championShipName: String
)
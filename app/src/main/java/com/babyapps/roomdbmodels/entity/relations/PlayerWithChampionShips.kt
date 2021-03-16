package com.babyapps.roomdbmodels.entity.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.babyapps.roomdbmodels.entity.ChampionShip
import com.babyapps.roomdbmodels.entity.Player

// N to M
data class PlayerWithChampionShips(
    @Embedded val player: Player,
    @Relation(
        parentColumn = "playerName",
        entityColumn = "championShipName",
        associateBy = Junction(PlayerChampionShipCrossRef::class)
    )
    val championShips: List<ChampionShip>
)
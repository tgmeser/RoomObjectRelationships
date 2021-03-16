package com.babyapps.roomdbmodels.entity.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.babyapps.roomdbmodels.entity.ChampionShip
import com.babyapps.roomdbmodels.entity.Player

//N to M
data class ChampionShipWithPlayers(
    @Embedded val championShip: ChampionShip,
    @Relation(
        parentColumn = "championShipName",
        entityColumn = "playerName",
        associateBy = Junction(PlayerChampionShipCrossRef::class)
    )
    val players: List<Player>
)
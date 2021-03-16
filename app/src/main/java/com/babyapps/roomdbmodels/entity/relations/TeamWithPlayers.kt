package com.babyapps.roomdbmodels.entity.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.babyapps.roomdbmodels.entity.Player
import com.babyapps.roomdbmodels.entity.Team

// 1 To N
data class TeamWithPlayers(
    @Embedded val team: Team,
    @Relation(
        parentColumn = "teamName",
        entityColumn = "teamName"
    ) val players: List<Player>
)
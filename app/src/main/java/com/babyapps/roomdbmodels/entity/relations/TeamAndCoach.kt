package com.babyapps.roomdbmodels.entity.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.babyapps.roomdbmodels.entity.Coach
import com.babyapps.roomdbmodels.entity.Team

//1 To 1 Relationship
data class TeamAndCoach(
    @Embedded val team: Team,
    @Relation(
        parentColumn = "teamName",
        entityColumn = "teamName"
    ) val coach: Coach
)
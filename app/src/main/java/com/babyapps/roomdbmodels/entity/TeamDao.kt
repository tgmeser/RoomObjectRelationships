package com.babyapps.roomdbmodels.entity

import androidx.room.*
import com.babyapps.roomdbmodels.entity.relations.*

@Dao
interface TeamDao {
    //Base Entities
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlayer(player: Player)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeam(team: Team)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoach(coach: Coach)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChampionShip(championShip: ChampionShip)

    //  N to M Relationship between Player - Championship
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlayerChampionShipCrossRef(crossRef: PlayerChampionShipCrossRef)


    // Team Leads Coach
    @Transaction
    @Query("select * from team where teamName = :teamName")
    suspend fun getTeamAndCoachWithTeamName(teamName: String): List<TeamAndCoach>


    @Transaction
    @Query("select * from team where teamName = :teamName")
    suspend fun getTeamWithPlayers(teamName: String): List<TeamWithPlayers>

    @Transaction
    @Query("select * from championship where championShipName = :championShipName")
    suspend fun getPlayersOfChampionShip(championShipName: String): List<ChampionShipWithPlayers>

    @Transaction
    @Query("select * from player where playerName = :playerName")
    suspend fun getChampionShipsOfPlayer(playerName: String): List<PlayerWithChampionShips>



}
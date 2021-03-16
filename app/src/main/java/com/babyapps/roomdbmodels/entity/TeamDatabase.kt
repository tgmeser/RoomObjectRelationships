package com.babyapps.roomdbmodels.entity

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.babyapps.roomdbmodels.entity.relations.PlayerChampionShipCrossRef

@Database(
    entities = [Team::class, Player::class, Coach::class, ChampionShip::class,
        PlayerChampionShipCrossRef::class],
    version = 1
)
abstract class TeamDatabase : RoomDatabase() {
    abstract fun teamDao(): TeamDao

    companion object {
        @Volatile // Preventing race conitions by Volatile, limiting just 1 thread
        private var INSTANCE: TeamDatabase? = null
        private val LOCK = Any()
        fun getInstance(context: Context): TeamDatabase {
            synchronized(LOCK) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    TeamDatabase::class.java,
                    "team_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}
package com.example.xo.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface PlayerDatabaseDao {

    @Insert
    fun insert(player:PlayerDetails)

    @Update
    fun update(player:PlayerDetails)


    @Query("SELECT * FROM leader_board_table ORDER BY score DESC")
    fun getAllPlayers(): LiveData<List<PlayerDetails>>

}
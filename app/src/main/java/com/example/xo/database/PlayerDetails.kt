package com.example.xo.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity( tableName="leader_board_table")
data class PlayerDetails(
    @PrimaryKey(autoGenerate = true)
    var Id: Long = 0L,
    @ColumnInfo(name = "name")
    var playerName:String="",
    @ColumnInfo(name = "won")
    var won:Int=0,
    @ColumnInfo(name = "loss")
    var loss:Int=0,
    @ColumnInfo(name = "draw")
    var draw:Int=0,
    @ColumnInfo(name = "score")
    var score:Int=0
)
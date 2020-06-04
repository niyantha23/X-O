package com.example.xo

import android.util.Log
import androidx.lifecycle.ViewModel

class GetNameViewModel:ViewModel() {
    var playerX:String=""
    var playerO:String=""

    fun getPlayerX(player:String){
        playerX=player
        Log.i("eeeeee",playerX)
    }
    fun getPlayerO(player:String){
        playerO=player
        Log.i("ddddd",playerO)

    }
}
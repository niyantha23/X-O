package com.example.xo

import android.app.Application
import android.content.Context
import android.util.Log
import android.view.View
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class GameViewModel() : ViewModel() {
//    private var viewModelJob = Job()
//    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    var activePlayer: Int = 0
    val _incre = MutableLiveData<Int>()
    val incre: LiveData<Int>
        get() = _incre

    //0:X   1:O  2: empty
    var gameState = arrayOf<Int>(2, 2, 2, 2, 2, 2, 2, 2, 2)
    val winningPositions = arrayOf(
        arrayOf(0, 1, 2),
        arrayOf(3, 4, 5),
        arrayOf(6, 7, 8),
        arrayOf(0, 3, 6),
        arrayOf(1, 4, 7),
        arrayOf(2, 5, 8),
        arrayOf(0, 4, 8),
        arrayOf(2, 4, 6)
    )
    val _gameActive = MutableLiveData<Boolean>()
    val gameActive:LiveData<Boolean>
get() = _gameActive
    val _gameOver = MutableLiveData<Boolean>()
val gameOver:LiveData<Boolean>
    get() = _gameOver
    var winner = MutableLiveData<String>()
 var playerX:String=""
    var playerO:String=""

    init {
        _gameActive.value = true
        _gameOver.value = false
        winner.value = ""
        _incre.value = 0

    }


    fun dropIn(view: View) {
        var counter: ImageView = view as ImageView
        var tappedCounter: Int = Integer.parseInt(counter.getTag().toString())
        if (gameState[tappedCounter] == 2 && gameActive.value!!) {
            _incre.value = incre.value?.plus(1)
            gameState[tappedCounter] = activePlayer
            counter.setTranslationY((-1500).toFloat())
            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.x1)
                activePlayer = 1
            } else if (activePlayer == 1) {
                counter.setImageResource(R.drawable.o)
                activePlayer = 0
            }
            counter.animate().translationYBy((1500).toFloat()).rotation((360).toFloat())
                .setDuration(600)
            for (winningPos in winningPositions) {
                if (gameState[winningPos[0]] == gameState[winningPos[1]] && gameState[winningPos[1]] == gameState[winningPos[2]] && gameState[winningPos[1]] != 2) {
                    _gameActive.value = false
                    if (activePlayer == 0) {
                        winner.value = playerO
                    } else
                        if (activePlayer == 1) {
                            winner.value = playerX
                        }
                    Log.i("dd", winner.value + "WONNNNNNNN")
                    _gameOver.value = true
                }
            }
        }

    }

    fun getPlayerX(player:String){
        playerX=player
        Log.i("eeeeee",playerX)
    }
    fun getPlayerO(player:String){
        playerO=player
        Log.i("ddddd",playerO)

    }
//    fun insertIntoDatabase(){
//
//    }
//    override fun onCleared() {
//        super.onCleared()
//        viewModelJob.cancel()
//    }

}
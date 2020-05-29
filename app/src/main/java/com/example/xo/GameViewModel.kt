package com.example.xo

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.google.android.material.snackbar.Snackbar

class GameViewModel : ViewModel() {
    var activePlayer: Int = 0

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
       var gameActive:Boolean=true
    fun dropIn(view: View) {
        var counter: ImageView = view as ImageView
        var tappedCounter: Int = Integer.parseInt(counter.getTag().toString())
        if (gameState[tappedCounter]==2 && gameActive){
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
                gameActive=false
                var winner:String=""
                if(activePlayer==0){
                    winner="O"
                }else
                    if (activePlayer==1){
                        winner="X"
                    }




                Log.i("dd", winner+"WONNNNNNNN")


            }
        }


    }
  }
}
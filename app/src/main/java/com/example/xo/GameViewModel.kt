package com.example.xo
import android.view.View
import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    var activePlayer: Int = 0
    val _incre = MutableLiveData<Int>()
    val incre: LiveData<Int>
        get() = _incre
    val xWon = MutableLiveData<Int>()
    val oWon = MutableLiveData<Int>()
    val draw = MutableLiveData<Int>()
   var check=0 //to check if someone win during the last turn
    //0:X   1:O  2: empty
    var gameState = arrayOf(2, 2, 2, 2, 2, 2, 2, 2, 2)
    private val winningPositions = arrayOf(
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
private val gameActive: LiveData<Boolean>
        get() = _gameActive
    private val _gameOver = MutableLiveData<Boolean>()
    val gameOver: LiveData<Boolean>
        get() = _gameOver
    var winner = MutableLiveData<String>()
    var playerX: String = ""
    var playerO: String = ""

    init {
        _gameActive.value = true
        _gameOver.value = false
        winner.value = ""
        _incre.value = 0
        xWon.value = 0
        oWon.value = 0
        draw.value = 0
    }

    fun dropIn(view: View) {
        val counter: ImageView = view as ImageView
        val tappedCounter: Int = Integer.parseInt(counter.tag.toString())
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
            counter.animate().translationYBy((1500).toFloat()).rotation((360).toFloat()).setDuration(400)
            for (winningPos in winningPositions) {
                if (gameState[winningPos[0]] == gameState[winningPos[1]] && gameState[winningPos[1]] == gameState[winningPos[2]] && gameState[winningPos[1]] != 2) {
                    _gameActive.value = false
                    if (activePlayer == 0) {
                        check=1
                        if (playerO != "")
                            winner.value = playerO
                        else
                            winner.value = "O"
                        oWon.value = oWon.value?.plus(1)
                    } else
                        if (activePlayer == 1) {
                            check=1
                            if (playerX != "")
                                winner.value = playerX
                            else
                                winner.value = "X"
                            xWon.value = xWon.value?.plus(1)
                        }
                    _gameOver.value = true
                }
            }
        }

    }

}
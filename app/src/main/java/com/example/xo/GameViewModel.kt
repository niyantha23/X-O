package com.example.xo

import android.view.View
import android.widget.ImageView
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    var activePlayer:Int=0
    //0: yellow 1: Red
     fun dropIn(view : View){
         var counter:ImageView= view as ImageView
        counter.setTranslationY((-1500).toFloat())
         if(activePlayer==0){
        counter.setImageResource(R.drawable.yellow)
         activePlayer=1}
        else if (activePlayer==1){
             counter.setImageResource(R.drawable.red)
             activePlayer=0
         }
        counter.animate().translationYBy((1500).toFloat()).rotation((3600).toFloat()).setDuration(600)


    }
}
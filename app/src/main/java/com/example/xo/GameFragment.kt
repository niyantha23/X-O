package com.example.xo

import android.app.Application
import android.graphics.drawable.Drawable
import android.nfc.Tag
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.xo.databinding.GameFragmentBinding
import kotlinx.android.synthetic.main.game_fragment.*
import kotlinx.coroutines.delay


class GameFragment : Fragment() {
    private lateinit var binding: GameFragmentBinding
    private lateinit var viewModel: GameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = DataBindingUtil.inflate(inflater, R.layout.game_fragment, container, false)

        viewModel  = ViewModelProviders.of(activity!!).get(GameViewModel::class.java)
        binding.gameViewModel = viewModel
        viewModel.gameOver.observe(
            viewLifecycleOwner,
            Observer { gameOver -> if (gameOver)
                gameFinished()
                 })
        binding.playAgain.setOnClickListener { playAgain() }
        viewModel.incre.observe(viewLifecycleOwner, Observer { increment ->
            if(increment%2==0){
                binding.turnImage.setImageResource(R.drawable.x1)
            }
            else if(increment%2!=0) {
                binding.turnImage.setImageResource(R.drawable.o)
            }
            if (increment >= 9) {
                gameFinished()
                binding.winnerText.text = "ITS A DRAW"
            }
        })
        return binding.root
    }

    private fun gameFinished() {
        binding.winnerText.text = "The Winner is " + viewModel.winner.value.toString()
        binding.winnerText.visibility = View.VISIBLE
        binding.playAgain.visibility = View.VISIBLE
        binding.turnImage.visibility=View.INVISIBLE
        binding.turnText.visibility=View.INVISIBLE
        Log.i("eef", "TRIGGEREDDDDDDDDDD")
        //insertIntoDatabase()
    }

    private fun playAgain() {
        binding.winnerText.visibility = View.INVISIBLE
        binding.playAgain.visibility = View.INVISIBLE
        binding.turnImage.visibility=View.VISIBLE
        binding.turnText.visibility=View.VISIBLE
        viewModel._incre.value = 0
        for (i in 0..binding.gridLayout.childCount) {
            var counter: ImageView? = (binding.gridLayout.getChildAt(i)) as? ImageView
            counter?.setImageDrawable(null)

        }
        for (i in 0..(viewModel.gameState.size - 1)) {
            viewModel.gameState[i] = 2
        }
        viewModel._gameActive.value = true
        viewModel.activePlayer = 0
    }

}

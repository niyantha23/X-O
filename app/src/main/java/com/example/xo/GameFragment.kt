package com.example.xo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.xo.databinding.GameFragmentBinding

class GameFragment : Fragment() {
    private lateinit var binding: GameFragmentBinding
    private lateinit var viewModel: GameViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.game_fragment, container, false)
        viewModel = ViewModelProviders.of(activity!!).get(GameViewModel::class.java)
        binding.gameViewModel = viewModel
        viewModel.gameOver.observe(
            viewLifecycleOwner,
            Observer { gameOver ->
                if (gameOver)
                    gameFinished()
            })
        binding.playAgain.setOnClickListener { playAgain() }
        viewModel.incre.observe(viewLifecycleOwner, Observer { increment ->
            if (increment % 2 == 0) { binding.turnImage.setImageResource(R.drawable.x1) }
            else if (increment % 2 != 0) { binding.turnImage.setImageResource(R.drawable.o) }
            if (increment >= 9 &&viewModel.check==1) {
                viewModel.draw.value = viewModel.draw.value?.plus(1)
                if (viewModel._gameActive.value==false){
                    viewModel.draw.value = viewModel.draw.value?.minus(1)
                }
                gameFinished()
                binding.winnerText.text = getString(R.string.It_a_draw)
            }
        })
        viewModel.oWon.observe(
            viewLifecycleOwner,
            Observer { won -> binding.oWin.text = won.toString() })
        viewModel.xWon.observe(
            viewLifecycleOwner,
            Observer { won -> binding.xWin.text = won.toString() })
        viewModel.draw.observe(
            viewLifecycleOwner,
            Observer { draw -> binding.drawNo.text = draw.toString() })
        return binding.root
    }

    private fun gameFinished() {
        binding.winnerText.text = getString(R.string.the_winner_is) + viewModel.winner.value.toString()
        binding.winnerText.visibility = View.VISIBLE
        binding.playAgain.visibility = View.VISIBLE
        binding.turnImage.visibility = View.INVISIBLE
        binding.turnText.visibility = View.INVISIBLE
    }

    private fun playAgain() {
        binding.winnerText.visibility = View.INVISIBLE
        binding.playAgain.visibility = View.INVISIBLE
        binding.turnImage.visibility = View.VISIBLE
        binding.turnText.visibility = View.VISIBLE
        viewModel._incre.value = 0
        for (i in 0..binding.gridLayout.childCount) {
            val counter: ImageView? = (binding.gridLayout.getChildAt(i)) as? ImageView
            counter?.setImageDrawable(null)
        }
        for (i in 0..(viewModel.gameState.size - 1)) {
            viewModel.gameState[i] = 2
        }
        viewModel._gameActive.value = true
        viewModel.activePlayer = 0
    }

}

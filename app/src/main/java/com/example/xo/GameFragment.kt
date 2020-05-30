package com.example.xo

import android.app.Application
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

    companion object {
        fun newInstance() = GameFragment()
    }
    private lateinit var binding: GameFragmentBinding
    private lateinit var viewModel: GameViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.game_fragment,container,false)
        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
        binding.gameViewModel=viewModel
        // need to change this
        binding.i00.setOnClickListener{view:View->viewModel.dropIn(view)}
        binding.i01.setOnClickListener{view:View->viewModel.dropIn(view)}
        binding.i02.setOnClickListener{view:View->viewModel.dropIn(view)}
        binding.i10.setOnClickListener{view:View->viewModel.dropIn(view)}
        binding.i11.setOnClickListener{view:View->viewModel.dropIn(view)}
        binding.i12.setOnClickListener{view:View->viewModel.dropIn(view)}
        binding.i20.setOnClickListener{view:View->viewModel.dropIn(view)}
        binding.i21.setOnClickListener{view:View->viewModel.dropIn(view)}
        binding.i22.setOnClickListener{view:View->viewModel.dropIn(view)}
        viewModel.gameOver.observe(viewLifecycleOwner, Observer { gameOver-> if (gameOver) gameFinished() })
        return binding.root
    }
    private fun gameFinished(){
        binding.winnerText.text="The Winner is"+viewModel.winner.toString()
        binding.winnerText.visibility=View.VISIBLE
        binding.playAgain.visibility=View.VISIBLE
        Log.i("eef","TRIGGEREDDDDDDDDDD")
    }

}

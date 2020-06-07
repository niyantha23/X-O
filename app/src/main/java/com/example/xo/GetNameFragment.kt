package com.example.xo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.xo.databinding.GetNameFragmentBinding

class GetNameFragment : Fragment() {
    private lateinit var viewModel: GameViewModel
    private lateinit var binding: GetNameFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.get_name_fragment, container, false)
        viewModel = ViewModelProviders.of(activity!!).get(GameViewModel::class.java)
        binding.startGame.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(GetNameFragmentDirections.actionGetNameToGameFragment())
            viewModel.playerO = binding.oName.text.toString()
            viewModel.playerX = binding.xName.text.toString() }
        return binding.root
    }
}

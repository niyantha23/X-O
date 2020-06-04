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
    private lateinit var binding : GetNameFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding  =
            DataBindingUtil.inflate(inflater,R.layout.get_name_fragment,container,false)
        viewModel  = ViewModelProviders.of(activity!!).get(GameViewModel::class.java)
//        val dB: PlayerDatabase = Room.databaseBuilder( context!!, PlayerDatabase::class.java, "PlayerDetails"
//        ).allowMainThreadQueries()
//            .build()

        binding.startGame.setOnClickListener{view:View->
            view.findNavController().navigate(GetNameFragmentDirections.actionGetNameToGameFragment())
            viewModel.playerO=binding.oName.text.toString()
            viewModel.playerX=binding.xName.text.toString()
//            dB.playerDatabaseDao.insert(PlayerDetails(1,viewModel.playerX,0,0,0,0))
//            dB.playerDatabaseDao.insert(PlayerDetails(2,viewModel.playerO,0,0,0,0))

          }
        return binding.root
    }


}

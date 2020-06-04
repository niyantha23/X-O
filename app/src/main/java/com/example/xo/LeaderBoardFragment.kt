package com.example.xo

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import com.example.xo.database.PlayerDatabase
import com.example.xo.databinding.LeaderBoardFragmentBinding


class LeaderBoardFragment : Fragment() {

    companion object {
        fun newInstance() = LeaderBoardFragment()
    }

    private lateinit var viewModel: LeaderBoardViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { val binding:LeaderBoardFragmentBinding=DataBindingUtil.inflate(inflater,R.layout.leader_board_fragment,container,false)
//        val dB: PlayerDatabase = Room.databaseBuilder( context!!, PlayerDatabase::class.java, "PlayerDetails"
//        ).allowMainThreadQueries()
//            .build()
//        binding.testText.text=dB.playerDatabaseDao.getAllPlayers().toString()
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LeaderBoardViewModel::class.java)
        // TODO: Use the ViewModel
    }

}

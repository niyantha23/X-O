package com.example.xo

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.xo.databinding.StartFragmentBinding

class StartFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: StartFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.start_fragment, container, false)
        binding.playGameButton.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(StartFragmentDirections.actionStartFragmentToGetName()) }
        setHasOptionsMenu(true)
        return binding.root
    }
        override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.drawer_menu, menu) }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.help -> {
                view!!.findNavController()
                    .navigate(StartFragmentDirections.actionStartFragmentToHelpFragment())
                return true
            }
            else
            -> super.onOptionsItemSelected(item)
        }
    }
}

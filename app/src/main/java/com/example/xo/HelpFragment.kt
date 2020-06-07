package com.example.xo
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.xo.databinding.HelpFragmentBinding

class HelpFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: HelpFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.help_fragment, container, false)
        return binding.root
    }
}

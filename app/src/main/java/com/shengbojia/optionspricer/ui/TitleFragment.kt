package com.shengbojia.optionspricer.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.shengbojia.optionspricer.R

import com.shengbojia.optionspricer.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [TitleFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [TitleFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(
            inflater, R.layout.fragment_title, container, false)

        binding.btnTitleBlackscholes.setOnClickListener {
            it.findNavController().navigate(R.id.action_titleFragment_to_blackScholesFragment)
        }

        return binding.root
    }

}

package com.shengbojia.optionspricer.ui


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.shengbojia.optionspricer.databinding.FragmentBlackScholesBinding

import com.shengbojia.optionspricer.R

/**
 * A simple [Fragment] subclass.
 *
 */
class BlackScholesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentBlackScholesBinding>(
            inflater, R.layout.fragment_black_scholes, container, false)

        return binding.root
    }

}

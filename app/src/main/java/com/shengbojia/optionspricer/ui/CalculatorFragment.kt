package com.shengbojia.optionspricer.ui


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.shengbojia.calculator.BlackScholesCalculator

import com.shengbojia.optionspricer.databinding.FragmentCalculatorBinding

import com.shengbojia.optionspricer.R

/**
 * A simple [Fragment] subclass.
 *
 */
class CalculatorFragment : Fragment() {
    private val calculator = BlackScholesCalculator()

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentCalculatorBinding>(
            inflater, R.layout.fragment_calculator, container, false)


        binding.btnCalcCalculate.setOnClickListener {
            calculateButtonClick(it)
        }

        return binding.root
    }

    private fun calculateButtonClick(view: View) {

    }


}

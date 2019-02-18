package com.shengbojia.optionspricer.ui

import android.content.Context
import android.databinding.DataBindingUtil
import android.hardware.input.InputManager
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.shengbojia.calculator.BlackScholesCalculator

import com.shengbojia.optionspricer.databinding.FragmentCalculatorBinding

import com.shengbojia.optionspricer.R
import kotlinx.android.synthetic.main.fragment_calculator.*
import com.shengbojia.calculator.BlackScholesCalculator.DEFAULT_PRECISION
import java.lang.NumberFormatException
import java.math.BigDecimal
import java.math.MathContext

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
        // TODO: Validate inputs as non empty
        Log.i("divide", "right before conversions")
        val stockPrice: BigDecimal = et_calc_stockinput.text.toString().toBigDecimal()
        Log.i("divide", "right after conversions")
        val strikePrice = et_calc_strikeinput.text.toString().toBigDecimal()
        val maturity = et_calc_timeinput.text.toString().toBigDecimal()
        Log.i("divide", "big decimal conversions")
        var volatility = et_calc_volinput.text.toString().toBigDecimal()
        volatility = percentToBigDecimal(volatility)
        Log.i("divide", "right after volaitility conversion")
        var riskFree = et_calc_rfinput.text.toString().toBigDecimal()
        riskFree = percentToBigDecimal(riskFree)
        Log.i("divide", "right after riskfree conversion")

        var callPrice = calculator.callPricing(
            stockPrice,
            strikePrice,
            maturity,
            volatility,
            riskFree
        )

        Log.i("divide", "call calculated")

        var putPrice = calculator.putPricing(
            stockPrice,
            strikePrice,
            maturity,
            volatility,
            riskFree
        )

        tv_calc_cprice.text = callPrice.toDouble().toString()
        tv_calc_pprice.text = putPrice.toDouble().toString()
        gridlayout_calc_output.visibility = View.VISIBLE

        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }


    private fun percentToBigDecimal(percent: BigDecimal,
                                    precision: MathContext = DEFAULT_PRECISION
    ): BigDecimal {
        Log.i("divide", "right before return")
        return percent.divide(BigDecimal.TEN, DEFAULT_PRECISION)
            .divide(BigDecimal.TEN, DEFAULT_PRECISION)
    }
}

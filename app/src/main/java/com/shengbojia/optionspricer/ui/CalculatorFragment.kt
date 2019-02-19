package com.shengbojia.optionspricer.ui

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView

import com.shengbojia.optionspricer.R
import com.shengbojia.optionspricer.calculator.OptionsCalculator
import com.shengbojia.optionspricer.databinding.FragmentCalculatorBinding

import kotlinx.android.synthetic.main.fragment_calculator.*

import java.math.BigDecimal

/**
 * A simple [Fragment] subclass.
 *
 */
class CalculatorFragment : Fragment() {
    private val calculator = OptionsCalculator()

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

        if (checkInputValidity()) {
            calculate()
        }

        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun checkInputValidity(): Boolean {
        return checkAndDisplayError(et_calc_stockinput, tv_calc_stockerror) and
                checkAndDisplayError(et_calc_strikeinput, tv_calc_strikeerror) and
                checkAndDisplayError(et_calc_timeinput, tv_calc_timeerror) and
                checkAndDisplayError(et_calc_volinput, tv_calc_volerror) and
                checkAndDisplayError(et_calc_rfinput, tv_calc_rferror)
    }

    private fun checkAndDisplayError(
        input: EditText,
        displayBox: TextView,
        error: String = "This cannot be empty!"
    ): Boolean {
        if (!validInput(input)) {
            displayBox.visibility = View.VISIBLE
            displayError(displayBox, error)
            return false
        }
        displayBox.visibility = View.INVISIBLE
        return true
    }

    private fun validInput(input: EditText): Boolean {
        return (input.text.toString()).isNotBlank()
    }

    private fun displayError(
        displayBox: TextView,
        error: String
    ) {
        displayBox.text = error
    }

    // TODO: Consider separating the execution of calculation to a different object

    private fun calculate() {

        Log.i("divide", "right before conversions")
        val stockPrice: BigDecimal = et_calc_stockinput.text.toString().toBigDecimal()
        Log.i("divide", "right after conversions")
        val strikePrice = et_calc_strikeinput.text.toString().toBigDecimal()
        val maturity = et_calc_timeinput.text.toString().toBigDecimal()
        Log.i("divide", "big decimal conversions")
        var volatility = et_calc_volinput.text.toString().toBigDecimal()
        volatility = calculator.percentToBigDecimal(volatility)
        Log.i("divide", "right after volaitility conversion")
        var riskFree = et_calc_rfinput.text.toString().toBigDecimal()
        riskFree = calculator.percentToBigDecimal(riskFree)
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
    }
}

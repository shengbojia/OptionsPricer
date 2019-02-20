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
import com.shengbojia.optionspricer.calculator.CalculatorInput
import com.shengbojia.optionspricer.calculator.OptionsCalculator
import com.shengbojia.optionspricer.databinding.FragmentCalculatorBinding

import kotlinx.android.synthetic.main.fragment_calculator.*

import java.math.BigDecimal
import java.text.NumberFormat

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

    /**
     * Starts the calculations.
     *
     * @param view the view that sends the action to this listener
     */
    private fun calculateButtonClick(view: View) {
        if (checkInputValidity()) {
            Log.d(TAG, "All inputs are valid")

            calculator.setData(packInputData())
            tv_calc_cprice.text = NumberFormat.getCurrencyInstance().format(calculator.callPrice().toDouble())
            tv_calc_pprice.text = NumberFormat.getCurrencyInstance().format(calculator.putPrice().toDouble())
            gridlayout_calc_output.visibility = View.VISIBLE
        }

        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    /**
     * Checks for valid input from all five edit texts. Returns true if all five have valid input, false
     * otherwise
     *
     * @return boolean true if all five edit texts contain valid input, false otherwise
     */
    private fun checkInputValidity(): Boolean {
        return checkAndDisplayError(et_calc_stockinput, tv_calc_stockerror) and
                checkAndDisplayError(et_calc_strikeinput, tv_calc_strikeerror) and
                checkAndDisplayError(et_calc_timeinput, tv_calc_timeerror) and
                checkAndDisplayError(et_calc_volinput, tv_calc_volerror) and
                checkAndDisplayError(et_calc_rfinput, tv_calc_rferror)
    }

    /**
     * Checks for valid input from the specified edit text, displays an error beside invalid ones. Returns true
     * if input is valid, false otherwise
     *
     * @param input edit text whose input is being checked
     * @param displayBox text view that will display an error
     * @param error string error message to be displayed
     * @return boolean true if no errors, false otherwise
     */
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

    /**
     * Returns false if the edit text contains no input, true otherwise.
     *
     * @param input edit text whose input is being validated
     * @return boolean true if there is input, false if blank
     */
    private fun validInput(input: EditText): Boolean {
        return (input.text.toString()).isNotBlank()
    }

    /**
     * Displays an error message on a specified text view.
     *
     * @param displayBox text view to display the error
     * @param error string error message to be displayed
     */
    private fun displayError(
        displayBox: TextView,
        error: String
    ) {
        displayBox.text = error
    }

    /**
     * Returns a calculator input object constructed from the converted user inputs.
     *
     * @return calculator input made from user inputted data
     */
    private fun packInputData(): CalculatorInput {
        return CalculatorInput(
            takeAndConvertInput(et_calc_stockinput),
            takeAndConvertInput(et_calc_strikeinput),
            takeAndConvertInput(et_calc_timeinput),
            takeAndConvertPercentInput(et_calc_volinput),
            takeAndConvertPercentInput(et_calc_rfinput)
        )
    }

    /**
     * Converts user inputs into big decimals, then returns it.
     *
     * @param inputField edit text from which user input is taken
     * @return big decimal converted from the original user input
     */
    private fun takeAndConvertInput(inputField: EditText): BigDecimal {
        return inputField.text.toString().toBigDecimal()
    }

    /**
     * Converts user inputs that are percentages into equivalent decimal values in big decimal, then returns it
     * @param percentInputField edit text from which the percentage form input is taken
     * @return big decimal representation of an equivalent decimal value to the inputted percentage
     */
    private fun takeAndConvertPercentInput(percentInputField: EditText): BigDecimal {
        return percentInputField.text
            .toString()
            .toBigDecimal()
            .divide(BigDecimal.TEN)
            .divide(BigDecimal.TEN)
    }

    companion object {
        private const val TAG = "CalcFrag"
    }
}

package com.shengbojia.optionspricer.calculator

import android.util.Log
import com.shengbojia.calculator.BlackScholesCalculator
import java.math.BigDecimal
import java.math.MathContext

class OptionsCalculator() : BlackScholesCalculator() {
    private lateinit var inputData: CalculatorInput
    // TODO: Calculate greeks

    fun setData(inputData: CalculatorInput?) {
        this.inputData = inputData ?: CalculatorInput(
            BigDecimal.ZERO,
            BigDecimal.ZERO,
            BigDecimal.ZERO,
            BigDecimal.ZERO,
            BigDecimal.ZERO
        )
    }

    fun callPrice(): BigDecimal {
        return super.callPricing(
            inputData.stock,
            inputData.strike,
            inputData.maturity,
            inputData.volatility,
            inputData.riskFree
        )
    }

    fun putPrice(): BigDecimal {
        return super.putPricing(
            inputData.stock,
            inputData.strike,
            inputData.maturity,
            inputData.volatility,
            inputData.riskFree
        )
    }

}
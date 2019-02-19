package com.shengbojia.optionspricer.calculator

import android.util.Log
import com.shengbojia.calculator.BlackScholesCalculator
import java.math.BigDecimal
import java.math.MathContext

class OptionsCalculator : BlackScholesCalculator() {
    // TODO: Calculate greeks

    fun percentToBigDecimal(percent: BigDecimal,
                                    precision: MathContext = DEFAULT_PRECISION
    ): BigDecimal {
        Log.i("divide", "right before return")
        return percent.divide(BigDecimal.TEN, DEFAULT_PRECISION)
            .divide(BigDecimal.TEN, DEFAULT_PRECISION)
    }
}
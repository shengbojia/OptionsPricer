package com.shengbojia.optionspricer.calculator

import com.shengbojia.calculator.BlackScholesCalculator
import java.math.BigDecimal

class OptionsCalculator : BlackScholesCalculator() {
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

    fun cDelta(): BigDecimal {
        return super.callDelta(
            inputData.stock,
            inputData.strike,
            inputData.maturity,
            inputData.volatility,
            inputData.riskFree
        )
    }

    fun cGamma(): BigDecimal {
        return super.callGamma(
            inputData.stock,
            inputData.strike,
            inputData.maturity,
            inputData.volatility,
            inputData.riskFree
        )
    }

    fun cVega(): BigDecimal {
        return super.callVega(
            inputData.stock,
            inputData.strike,
            inputData.maturity,
            inputData.volatility,
            inputData.riskFree
        )
    }

    fun cTheta(): BigDecimal {
        return super.callTheta(
            inputData.stock,
            inputData.strike,
            inputData.maturity,
            inputData.volatility,
            inputData.riskFree
        )
    }

    fun cRho(): BigDecimal {
        return super.callRho(
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

    fun pDelta(): BigDecimal {
        return super.putDelta(
            inputData.stock,
            inputData.strike,
            inputData.maturity,
            inputData.volatility,
            inputData.riskFree
        )
    }

    fun pGamma(): BigDecimal {
        return super.putGamma(
            inputData.stock,
            inputData.strike,
            inputData.maturity,
            inputData.volatility,
            inputData.riskFree
        )
    }

    fun pVega(): BigDecimal {
        return super.putVega(
            inputData.stock,
            inputData.strike,
            inputData.maturity,
            inputData.volatility,
            inputData.riskFree
        )
    }

    fun pTheta(): BigDecimal {
        return super.putTheta(
            inputData.stock,
            inputData.strike,
            inputData.maturity,
            inputData.volatility,
            inputData.riskFree
        )
    }

    fun pRho(): BigDecimal {
        return super.putRho(
            inputData.stock,
            inputData.strike,
            inputData.maturity,
            inputData.volatility,
            inputData.riskFree
        )
    }
}
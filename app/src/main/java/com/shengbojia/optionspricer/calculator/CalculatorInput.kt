package com.shengbojia.optionspricer.calculator

import java.math.BigDecimal

data class CalculatorInput(
    val stock: BigDecimal,
    val strike: BigDecimal,
    val maturity: BigDecimal,
    val volatility: BigDecimal,
    val riskFree: BigDecimal
)
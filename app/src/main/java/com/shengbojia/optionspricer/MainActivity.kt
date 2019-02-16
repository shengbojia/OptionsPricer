package com.shengbojia.optionspricer

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.shengbojia.optionspricer.databinding.ActivityMainBinding
import com.shengbojia.calculator.BlackScholesCalculator


class MainActivity : AppCompatActivity() {
    val calculator = BlackScholesCalculator()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }
}

package com.shengbojia.optionspricer

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.shengbojia.calculator.BlackScholesCalculator
import com.shengbojia.optionspricer.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    val calculator = BlackScholesCalculator()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,
            R.layout.activity_main
        )
    }
}

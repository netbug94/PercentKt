package com.example.percentkt.engine_logic

// This does the calculation
data class PercentFunctions(var amount: Float = 0F, var percent: Int = 0) {
    val percentageOfBase: Float
        get() = amount / 100 * percent
    val basePlusPercentage: Float
        get() = amount + percentageOfBase

}

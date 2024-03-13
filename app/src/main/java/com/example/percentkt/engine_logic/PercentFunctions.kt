package com.example.percentkt.engine_logic

data class PercentFunctions(var amount: Float = 0F, var percent: Int = 18) {
    val percentageOfBase: Float
        get() = amount / 100 * percent
    val basePlusPercentage: Float
        get() = amount + percentageOfBase
}

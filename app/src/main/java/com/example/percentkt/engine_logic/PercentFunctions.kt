package com.example.percentkt.engine_logic

data class PercentFunctions(var amount: Float = 0F, var percent: Int = 0) {
    val percentageOfBase: Float
        get() = amount / 100 * percent
    val basePlusPercentage: Float
        get() = amount + percentageOfBase

    // Call this variables for only 2 decimals format
    val formattedBase = "%.2f".format(percentageOfBase)
    val formattedBasePlus = "%.2f".format(basePlusPercentage)
}

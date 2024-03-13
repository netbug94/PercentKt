package com.example.percentkt

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import com.example.percentkt.view.MainScreenH
import com.example.percentkt.view.MainScreenV

object UIHandler{
    @Composable
    fun ScreenHandler() {
        val screenConfig = LocalConfiguration.current
        val flipScreen = screenConfig.orientation == Configuration.ORIENTATION_PORTRAIT

        if (flipScreen) {
            MainScreenV()
        } else {
            MainScreenH()
        }
    }
}
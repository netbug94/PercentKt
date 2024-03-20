package com.example.percentkt

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.platform.LocalConfiguration
import com.example.percentkt.view.MainScreenH
import com.example.percentkt.view.MainScreenV

// This file handles screen rotation
object UIHandler {
    @Composable
    fun ScreenHandler() {
        var orientation by remember { mutableIntStateOf(Configuration.ORIENTATION_PORTRAIT) }
        val configuration = LocalConfiguration.current

// If the configuration changes then this will launch a new coroutine scope for it
        LaunchedEffect(configuration) {
// Save any changes to the orientation value on the configuration object
            snapshotFlow { configuration.orientation }
                .collect { orientation = it }
        }

        when (orientation) {
            Configuration.ORIENTATION_LANDSCAPE -> {
                MainScreenH()
            }

            else -> {
                MainScreenV()
            }
        }
    }
}
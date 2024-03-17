package com.example.percentkt.engine_logic

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel

class PercentKtViewModel : ViewModel() {
    var amount by mutableStateOf(TextFieldValue(""))
    var percent by mutableStateOf(TextFieldValue(""))
}



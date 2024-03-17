package com.example.percentkt.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.percentkt.engine_logic.PercentFunctions
import com.example.percentkt.engine_logic.PercentKtViewModel

@Preview(showBackground = true)
@Composable
fun MainScreenH() {
    val viewModel: PercentKtViewModel = viewModel()
    val amountValue = viewModel.amount.text.toFloatOrNull() ?: 0f
    val percentValue = viewModel.percent.text.toIntOrNull() ?: 0
    val percentageCalculator = PercentFunctions(amount = amountValue, percent = percentValue)

// Container
    Column(modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

// Result + Divider + Input -> Container
        Column(modifier = Modifier
            .fillMaxSize()
            .weight(6f)
            .padding(top = 10.dp)) {
// Results container
            Column(modifier = Modifier
                .fillMaxSize()
                .weight(6f)
                .padding(horizontal = 50.dp)) {

                Row(modifier = Modifier
                    .fillMaxSize()
                    .shadow(elevation = 2.dp)
                    .weight(2f),
                    verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Base + Result = ${percentageCalculator.basePlusPercentage}", modifier = Modifier.padding(start = 15.dp))
                }
                Spacer(modifier = Modifier
                    .fillMaxSize()
                    .weight(0.3f)
                )
                Row(modifier = Modifier
                    .fillMaxSize()
                    .shadow(elevation = 2.dp)
                    .weight(2f),
                    verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Percentage Result = ${percentageCalculator.percentageOfBase}", modifier = Modifier.padding(start = 15.dp))
                }
            }
// Divider container
            Column(modifier = Modifier
                .fillMaxSize()
                .weight(.8f)
                .padding(horizontal = 20.dp)) {

                Spacer(modifier = Modifier
                    .height(12.dp)
                )
                HorizontalDivider(
                    modifier = Modifier
                        .height(1.dp), color = Color.Black
                )
                Spacer(modifier = Modifier
                    .height(8.dp)
                )
            }
// Inputs container
            Column(modifier = Modifier
                .fillMaxSize()
                .weight(6f)
                .padding(horizontal = 20.dp), horizontalAlignment = Alignment.CenterHorizontally) {

                OutlinedTextField(
                    value = viewModel.percent,
                    onValueChange = { viewModel.percent = it },
                    modifier = Modifier
                        .fillMaxWidth(),
                    singleLine = true,
                    label = { Text(text = "Enter %") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done
                    )
                )
                Spacer(modifier = Modifier
                )
                OutlinedTextField(
                    value = viewModel.amount,
                    onValueChange = { viewModel.amount = it },
                    modifier = Modifier
                        .fillMaxWidth(),
                    singleLine = true,
                    label = { Text("Enter base amount") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done
                    )
                )
            }
        }
// Clear button
        Column(modifier = Modifier
            .fillMaxSize()
            .weight(1.5f)
            .padding(horizontal = 100.dp),
            verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier
                .fillMaxSize()
                .weight(.3f))
            Button(modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .padding(horizontal = 80.dp),
                onClick = {
                    viewModel.amount = TextFieldValue("")
                    viewModel.percent = TextFieldValue("") }) {
                Text(text = "Clear")
            }
            Spacer(modifier = Modifier
                .fillMaxSize()
                .weight(.5f))
        }
    }
}

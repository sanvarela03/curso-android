package com.example.curso.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.curso.ui.viewmodels.UserSaveViewModel

@Composable
@Preview(showBackground = true)
fun SaveUserForm(
    modifier: Modifier = Modifier,
    viewModel: UserSaveViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    var user by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Text(
                "Hola, ${uiState.userName}",
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.padding(top = 32.dp)
            )
            TextField(
                value = user,
                onValueChange = { user = it }
            )
            Button(onClick = { viewModel.guardar(user) }) {
                Text("AGREGAR")
            }
            Button(
                colors = ButtonColors(
                    contentColor = Color.White,
                    disabledContentColor = Color.White,
                    containerColor = Color.Red,
                    disabledContainerColor = Color.Red
                ),
                onClick = { viewModel.borrar() }
            ) {
                Text("Borrar")
            }
        }
    }
}
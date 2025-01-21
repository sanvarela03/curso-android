package com.example.curso.ui.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.curso.domain.data.TokenManager
import com.example.curso.ui.events.CatEvent
import kotlinx.coroutines.launch

@Composable
fun TokenView() {
    val context = LocalContext.current
    val dataStore = remember {
        TokenManager(context)
    }
    val token by dataStore.getAccessToken().collectAsStateWithLifecycle("")
    val coroutineScope = rememberCoroutineScope()
    var newToken by rememberSaveable { mutableStateOf("") }

    Scaffold { padding ->
        Column(
            modifier = Modifier.padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Token actual: ${token ?: "sin token"}", fontSize = 32.sp)

            OutlinedTextField(
                value = newToken,
                label = { Text("Token") },
                onValueChange = { newToken = it },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            )
            Button(onClick = {
                coroutineScope.launch {
                    dataStore.saveAccessToken(newToken)
                }
            }) {
                Text("Guardar token")
            }

            Button(
                colors = ButtonColors(
                    contentColor = Color.White,
                    disabledContentColor = Color.White,
                    containerColor = Color.Red,
                    disabledContainerColor = Color.Red
                ),
                onClick = {
                    coroutineScope.launch {
                        dataStore.deleteAccessToken()
                    }
                },
            ) {
                Text("Borrar token")
            }
        }
    }
}
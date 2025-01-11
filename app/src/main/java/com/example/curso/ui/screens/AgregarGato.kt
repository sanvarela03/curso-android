package com.example.curso.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun FormularioAgregarGato() {
    var nombre by rememberSaveable { mutableStateOf("") }
    var genero by rememberSaveable { mutableStateOf("") }
    var edad by rememberSaveable { mutableStateOf("") }
    var peso by rememberSaveable { mutableStateOf("") }
    var color by rememberSaveable { mutableStateOf("") }


    var gatos by rememberSaveable { mutableStateOf(listOf<Gato>()) }
    val spacer = 20.dp
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        ) {
            Text("Gato", fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
            OutlinedTextField(
                value = nombre,
                label = { Text("Nombre") },
                onValueChange = { nombre = it },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            )

            OutlinedTextField(
                value = genero,
                label = { Text("Género") },
                onValueChange = { genero = it },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            )
            OutlinedTextField(
                value = edad,
                label = { Text("Edad") },
                onValueChange = { edad = it },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            )
            OutlinedTextField(
                value = peso,
                label = { Text("Peso") },
                onValueChange = { peso = it },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            )
            OutlinedTextField(
                value = color,
                label = { Text("Color") },
                onValueChange = { color = it },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            )
            OutlinedButton(
                onClick = {
                    gatos = gatos + Gato(nombre, genero, edad, peso, color)
                    nombre = ""
                    genero = ""
                    edad = ""
                    peso = ""
                    color = ""
                    focusManager.clearFocus()
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(5.dp),
            ) {
                Text("Guardar")
            }

            Spacer(modifier = Modifier.height(spacer))
            HorizontalDivider(thickness = 1.dp, color = Color.Black)
            Spacer(modifier = Modifier.height(spacer))
            Text(text = nombre)
            Text(text = color)
            Text(
                text = gatos.toString(),
                color = Color(0xFF188038),
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold
            )

//            LazyColumn {
//                items(gatos) { gato ->
//                    Text(text = gato.nombre)
//                    Text(text = gato.color)
//                }
//            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun FormularioAgregarGatoTestPreview() {
    FormularioAgregarGato()
}

data class Gato(
    val nombre: String = "NaN",
    val genero: String = "NaN",
    val edad: String = "NaN",
    val peso: String = "NaN",
    val color: String = "NaN"
)
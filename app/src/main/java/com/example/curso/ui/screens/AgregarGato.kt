package com.example.curso.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.curso.ui.components.CatCard
import com.example.curso.ui.events.CatEvent
import com.example.curso.ui.navigation.rutes.Rutas
import com.example.curso.ui.viewmodels.CatsViewModel


@Composable
fun FormularioAgregarGato(
    viewModel: CatsViewModel = viewModel(),
    go: (Any) -> Unit = {}
) {
    val cat = viewModel.state
    val spacer = 10.dp
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
//            .verticalScroll(rememberScrollState())
            .padding(top = 20.dp, end = 5.dp, start = 5.dp),
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
                value = cat.nombre,
                label = { Text("Nombre") },
                onValueChange = { viewModel.onEvent(CatEvent.NameChanged(it)) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            )

            OutlinedTextField(
                value = cat.genero,
                label = { Text("Género") },
                onValueChange = { viewModel.onEvent(CatEvent.GenderChanged(it)) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            )
            OutlinedTextField(
                value = cat.edad,
                label = { Text("Edad") },
                onValueChange = { viewModel.onEvent(CatEvent.AgeChanged(it)) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            )
            OutlinedTextField(
                value = cat.peso,
                label = { Text("Peso") },
                onValueChange = { viewModel.onEvent(CatEvent.WeightChanged(it)) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            )
            OutlinedTextField(
                value = cat.color,
                label = { Text("Color") },
                onValueChange = { viewModel.onEvent(CatEvent.ColorChanged(it)) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            )
            OutlinedButton(
                onClick = {
                    viewModel.onEvent(CatEvent.onSave)
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
            Text(text = cat.nombre)
            Text(text = cat.color)
        }
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            items(viewModel.gatos) { gato ->
                CatCard(gato, { go(Rutas.Cat().toParams(gato)) })
            }
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
package com.example.curso.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.curso.ui.states.CatState
import com.example.curso.ui.viewmodels.CatViewModel

@Composable
fun CatDetail(viewModel: CatViewModel = viewModel()) {
    val cat = viewModel.state

    val spacer = 10.dp
    val fontSize = 20.sp
    Column(
        modifier = Modifier.padding(15.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text("Detalle Gato", fontSize = 24.sp, fontWeight = FontWeight.ExtraBold)
        }
        Spacer(modifier = Modifier.height(spacer))
        HorizontalDivider()
        Spacer(modifier = Modifier.height(spacer))
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text("Nombre: ${cat.nombre}", fontSize = fontSize)
                Text("Color: ${cat.color}", fontSize = fontSize)
                Text("Edad: ${cat.edad} años", fontSize = fontSize)
                Text("Genero: ${cat.genero}", fontSize = fontSize)
                Text("Peso: ${cat.peso} kg", fontSize = fontSize)
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CatDetailPreview() {
    CatDetail()
}
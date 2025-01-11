package com.example.curso.ui.screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.curso.R
import com.example.curso.ui.theme.Clon

@Composable
fun Contenedores(contenedor: Contenedor = Contenedor.COLUMNA) {
    when (contenedor) {
        Contenedor.COLUMNA -> {
            Columna()
        }

        Contenedor.FILA -> {
            Fila()
        }

        Contenedor.CAJA -> {
            Caja()
        }
    }
}

@Composable
fun Columna() {
    var counter by remember { mutableIntStateOf(0) }
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .padding(top = 20.dp)
            .background(color = Color(0xFFFF6347))
            .border(
                border = BorderStroke(width = 3.dp, Color.LightGray),
                shape = RoundedCornerShape(20.dp)
            ),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        repeat(counter) {
            Clon()
        }

        Clonar(
            counter,
            handleClick = {
                ++counter
            },
            handleLongClick = {
                --counter
            }
        )
        Button(
            onClick = {
                Toast.makeText(context, "Hola", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text("Mostrar toast")
        }
    }
}

@Composable
fun Fila() {
    Row(
        modifier = Modifier
            .padding(top = 20.dp)
            .background(color = Color(0xFFFF6347))
            .border(
                border = BorderStroke(width = 3.dp, Color.LightGray),
                shape = RoundedCornerShape(20.dp)
            )
    ) {
        Clon()
        Clon()
        Clon()
    }
}

@Composable
fun Caja() {
    Box(
        modifier = Modifier
            .padding(top = 20.dp)
            .background(color = Color(0xFFFF6347))
            .border(
                border = BorderStroke(width = 3.dp, Color.Black),
                shape = RoundedCornerShape(20.dp)
            )
    ) {
        Clon(100.dp)
        Clon(200.dp)
        Clon(300.dp)
        Clon(400.dp)
        Clon(500.dp)
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Clonar(counter: Int, handleClick: (Int) -> Unit, handleLongClick: (Int) -> Unit) {
    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(15.dp))
            .background(Color.Cyan)
            .padding(vertical = 8.dp, horizontal = 20.dp)
            .wrapContentHeight()
            .combinedClickable(
                onClick = { handleClick(counter) },
                onLongClick = { handleLongClick(counter) },
                onLongClickLabel = "Borrar clon"
            ),
    ) {
        Text("Contador: ${counter}")
    }
}

enum class Contenedor {
    CAJA,
    FILA,
    COLUMNA
}
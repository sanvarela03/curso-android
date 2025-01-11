package com.example.curso.kotlintest


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.traceEventEnd
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.widget.ConstraintLayout

@Composable
fun ColumnTest1() {
    Column(
        modifier = Modifier
            .size(100.dp)
            .background(Color.Red)
            .padding(5.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Blue)
        ) {
            Text("Hola 1")
            Text("Hola 2")
            Text("Hola 3")
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun ColumnTestPreview() {
//    ColumnTest()
//}

//@Composable
//@Preview(showBackground = true)
//fun BoxTest() {
//    Box(
//        modifier = Modifier
//            .size(200.dp)
//            .background(Color.Gray),
//        contentAlignment = Alignment.Center
//    ) {
//        Text("Texto centrado", color = Color.White)
//    }
//}

//@Composable
//@Preview(showBackground = true)
//fun BoxTestPreview() {
//    BoxTest()
//}
@Composable
fun ColumnTest() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Elemento 1")
        Text("Elemento 2")
        Text("Elemento 3")
    }
}


@Composable
fun RowTest() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("Elemento A")
        Text("Elemento B")
        Text("Elemento C")
    }
}






@Composable
@Preview(showBackground = true)
fun LazyColumnTest() {
    val listItems = listOf("A", "B", "C", "D")
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(listItems) { index ->
            Text("Elemento $index")
        }
    }
}











@Composable
fun LazyRowTest() {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(10) { index ->
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Blue),
                contentAlignment = Alignment.Center
            ) {
                Text("Item $index", color = Color.White)
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldTest() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("App Bar") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* Acción */ }) {
                Icon(Icons.Default.Add, contentDescription = null)
            }
        },
        content = { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                Text("Contenido principal")
            }
        }
    )
}


//@Composable
//@Preview(showBackground = true)
//fun BorderTest() {
//    Box(
//        modifier = Modifier
//            .size(100.dp)
//            .border(5.dp, Color.Black)
//    )
//
//}


@Composable
//@Preview(showBackground = true)
fun WeightTest() {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .background(Color.Red)
                    .size(100.dp)
            )
            Box(
                modifier = Modifier
                    .weight(2f)
                    .background(Color.Blue)
                    .size(100.dp)
            )
            Box(
                modifier = Modifier
                    .weight(1f)
                    .background(Color.Green)
                    .size(100.dp)
            )
        }
    }
}


//@Composable
//@Preview(showBackground = true)
//fun BackgroudTest() {
//    Column(
//        modifier = Modifier
//            .background(Color.Magenta)
//            .fillMaxSize()
//    ) {
//        Box(
//            modifier = Modifier
//                .background(Color.Cyan)
//                .size(100.dp)
//        )
//    }
//}


@Composable
fun ClickeableTest() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .clickable { /* Acción */ }
    )
}


@Composable
fun PointerInput() {
    Box(
        modifier = Modifier.pointerInput(Unit) {
            detectTapGestures(
                onTap = { /* Acción */ },
                onPress = {/* Acción */ },
                onDoubleTap = {/* Acción */ },
                onLongPress = {/* Acción */ }
            )
        }
    )
}


@Composable
//@Preview(showBackground = true)
fun GraphicsLayerTest() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .graphicsLayer(rotationZ = 45f, scaleX = 1.5f, scaleY = 1.5f)
                .size(100.dp)
                .background(Color.Green)
        )
    }
}


@Composable
fun RecompositionTest(
    param1: String = "param1",
    param2: String = "param2",
    param3: String = "param3",
    param4: String = "param4",
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(param1)
        Text(param2)
        Text(param3)
        Text(param4)
    }
}

@Composable
//@Preview(showBackground = true)
fun RecompositionTestPreview() {
    RecompositionTest()
}


@Composable
//@Preview(showBackground = true)
fun AlertDialogTest() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AlertDialog(
            title = { Text("Ejemplo dialogo") },
            text = { Text("Descripción alerta") },
            onDismissRequest = {

            },
            confirmButton = {
                OutlinedButton(onClick = {}) {
                    Text("Confirmar")
                }
            })
    }
}


@Composable
//@Preview(showBackground = true)
fun BottomAppBarTest() {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = Color.Cyan
            ) { }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("CONTENIDO")
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
//@Preview(showBackground = true)
fun TopAppBarTest() {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.border(1.dp, Color.Black),
                title = {
                    Row(
                        modifier = Modifier
                            .background(Color.Red)
                            .padding(5.dp)
                            .fillMaxWidth()
                    ) {
                        Box(
                            modifier = Modifier
                                .background(Color.Blue)
                                .size(50.dp)
                                .weight(1f)
                        )
                        Box(
                            modifier = Modifier
                                .background(Color.Green)
                                .size(50.dp)
                                .weight(2f)
                        )
                        Box(
                            modifier = Modifier
                                .background(Color.Blue)
                                .size(50.dp)
                                .weight(1f)
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("CONTENIDO")
        }
    }
}


@Composable
//@Preview(showBackground = true)
fun ButtonsTest() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Button(onClick = {}) {
            Text("Button")
        }
        FilledTonalButton(onClick = {}) {
            Text("FilledTonalButton")
        }
        OutlinedButton(onClick = {}) {
            Text("OutlinedButton")
        }
        ElevatedButton(onClick = {}) {
            Text("ElevatedButton")
        }
        TextButton(onClick = {}) {
            Text("TextButton")
        }
        FloatingActionButton(onClick = {}) {
            Text("FloatingActionButton")
        }
        RadioButton(onClick = {}, selected = true)
    }
}


@Composable
//@Preview(showBackground = true)
fun DividerTest() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Red)
            )
            HorizontalDivider(thickness = 2.dp, color = Color.Black)
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Red)
            )
        }
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Red)
            )
            VerticalDivider(thickness = 2.dp, color = Color.Black)
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Red)
            )
        }
    }
}

@Composable
//@Preview(showBackground = true)
fun CardTest() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        OutlinedCard(
            modifier = Modifier
                .size(200.dp),
            border = BorderStroke(2.dp, color = Color.Black)
        ) {
            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                Text("Outlined")
            }
        }

        ElevatedCard(
            modifier = Modifier
                .size(200.dp),
        ) {
            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                Text("Elevated")
            }
        }
    }
}


@Composable
//@Preview(showBackground = true)
fun TextFieldTest() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        TextField(
            value = "",
            placeholder = { Text("TextField") },
            onValueChange = {}
        )
        OutlinedTextField(
            value = "",
            placeholder = { Text("OutlinedTextField") },
            onValueChange = {}
        )
    }
}







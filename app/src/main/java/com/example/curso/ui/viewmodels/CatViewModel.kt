package com.example.curso.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.example.curso.ui.navigation.rutes.Rutas
import com.example.curso.ui.states.CatState

class CatViewModel(
    private val savedState: SavedStateHandle
) : ViewModel() {
    var state by mutableStateOf(CatState())

    init {
        val args = savedState.toRoute<Rutas.Cat>()
        state = args.toCatState()
    }
}
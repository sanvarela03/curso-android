package com.example.curso.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.example.curso.ui.events.CatEvent
import com.example.curso.ui.screens.Gato
import com.example.curso.ui.states.CatState

class CatsViewModel() : ViewModel() {
    var state by mutableStateOf(CatState())
    var gatos by mutableStateOf(listOf<Gato>())

    init {
//        gatos = listOf(
//            Gato("MichiA","F","2","3","Blanco"),
//            Gato("MichiB","M","3","4","Negro"),
//            Gato("MichiC","M","4","4","Amarillo"),
//        )
    }

    fun onEvent(event: CatEvent) {
        when (event) {
            is CatEvent.NameChanged -> {
                state = state.copy(nombre = event.name)
            }

            is CatEvent.AgeChanged -> {
                state = state.copy(edad = event.age)
            }

            is CatEvent.ColorChanged -> {
                state = state.copy(color = event.color)
            }

            is CatEvent.GenderChanged -> {
                state = state.copy(genero = event.gender)
            }

            is CatEvent.WeightChanged -> {
                state = state.copy(peso = event.weight)
            }

            CatEvent.onSave -> {
                addCat()
                resetState()
            }
        }
    }

    private fun addCat() {
        gatos = gatos + Gato(state.nombre, state.genero, state.edad, state.peso, state.color)
    }

    private fun resetState() {
        state = CatState()
    }
}
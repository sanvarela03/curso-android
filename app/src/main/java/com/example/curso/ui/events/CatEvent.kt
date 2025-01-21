package com.example.curso.ui.events

import com.example.curso.ui.states.CatState

sealed class CatEvent {
    data class NameChanged(val name: String) : CatEvent()
    data class GenderChanged(val gender: String) : CatEvent()
    data class AgeChanged(val age: String) : CatEvent()
    data class WeightChanged(val weight: String) : CatEvent()
    data class ColorChanged(val color: String) : CatEvent()
    object onSave : CatEvent()
}
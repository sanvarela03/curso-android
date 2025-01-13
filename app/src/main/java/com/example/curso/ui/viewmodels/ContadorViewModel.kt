package com.example.curso.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ContadorViewModel : ViewModel() {
    var contador by mutableStateOf(0)

    fun onIncrement() {
        contador++
    }
}
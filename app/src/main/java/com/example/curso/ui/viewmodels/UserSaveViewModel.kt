package com.example.curso.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.curso.MainActivity
import com.example.curso.domain.data.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


data class UiState(
    val userName: String = ""
)

@HiltViewModel
class UserSaveViewModel
@Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    val uiState: StateFlow<UiState> = userRepository.userNameActual.map { userName ->
        UiState(userName)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = UiState("Desconocido")
    )

    fun guardar(userName: String) {
        viewModelScope.launch {
            userRepository.guardarUserName(userName)
        }
    }

    fun borrar() {
        viewModelScope.launch {
            userRepository.borrarUserName()
        }
    }
}
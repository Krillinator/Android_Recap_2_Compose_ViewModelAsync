package com.krillinator.recap_2_viewmodel_api.ui.viewModels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.krillinator.recap_2_viewmodel_api.api.Fox
import com.krillinator.recap_2_viewmodel_api.api.FoxRetrofit
import kotlinx.coroutines.launch
import java.lang.Exception

class FoxViewModel : ViewModel() {

    private val _foxUiState = mutableStateOf<Fox?>(null)
    var foxUiState : State<Fox?> = _foxUiState

    fun fetchFoxImage() {
        viewModelScope.launch {
            try {
                _foxUiState.value = FoxRetrofit.fetchFox()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}
package com.example.tva.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tva.usecase.GetAllHeroUseCase
import com.example.tva.usecase.GetHeroByIdUseCase
import com.example.tva.util.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HeroViewModel(
    private val getAllHeroUseCase: GetAllHeroUseCase,
    private val getHeroByIdUseCase: GetHeroByIdUseCase

) : ViewModel() {
    private val _uiState = MutableStateFlow(HeroUiState())
    val uiState: StateFlow<HeroUiState> = _uiState

    //get all hero
    fun getAllHero() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(
                isLoading = true,
                error = null
            )

            when (val result = getAllHeroUseCase()) {
                is Result.Success -> {
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        heroes = result.data

                    )
                }

                is Result.Error -> {
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        error = result.message
                    )

                }

            }
        }
    }

    // get hero by id

    fun getHeroById(id: Long) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(
                isLoading = true,
                error = null
            )

            when (val result = getHeroByIdUseCase(id)) {
                is Result.Success -> {
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        selectedHero = result.data
                    )
                }

                is Result.Error -> {
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        error = result.message
                    )
                }
            }
        }

    }

    //clear stack

    fun clearSelectedHero() {
        _uiState.value = _uiState.value.copy(
            selectedHero = null
        )

    }
}

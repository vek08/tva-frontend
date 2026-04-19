package com.example.tva.viewmodel

import com.example.tva.model.HeroCharacterResponse

data class HeroUiState(
    val isLoading: Boolean=false,
    val heroes:List<HeroCharacterResponse> = emptyList(),
    val selectedHero : HeroCharacterResponse?=null,
    val error:String?=null

)

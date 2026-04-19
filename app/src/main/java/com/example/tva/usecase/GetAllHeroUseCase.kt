package com.example.tva.usecase

import com.example.tva.model.HeroCharacterResponse
import com.example.tva.repository.HeroCharacterRepo
import com.example.tva.util.Result

class GetAllHeroUseCase(
    private val repo: HeroCharacterRepo
) {
    suspend operator fun invoke(): Result<List<HeroCharacterResponse>>{
            return repo.getAllHero()
    }
}
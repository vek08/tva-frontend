package com.example.tva.usecase

import com.example.tva.model.HeroCharacterResponse
import com.example.tva.repository.HeroCharacterRepo
import com.example.tva.util.Result

class GetHeroByIdUseCase(
    private val repo: HeroCharacterRepo
) {
    suspend operator fun invoke(id:Long): Result<HeroCharacterResponse>{
        return repo.getHeroById(id)
    }
}
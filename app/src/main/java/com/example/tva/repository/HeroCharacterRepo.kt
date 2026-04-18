package com.example.tva.repository

import com.example.tva.model.HeroCharacterRequest
import com.example.tva.model.HeroCharacterResponse
import com.example.tva.network.HeroCharacterApiService
import com.example.tva.util.Result

class HeroCharacterRepo(
    private val api: HeroCharacterApiService
) {
    //    get all hero
    suspend fun getAllHero(): Result<List<HeroCharacterResponse>> {
        return try {
            val response = api.getAllHero()
            if (response.isSuccessful) {
                Result.Success(response.body() ?: emptyList())
            } else {
                Result.Error("Error: ${response.code()}")
            }
        } catch (e: Exception) {
            Result.Error(e.message ?: "Unknown error")
        }
    }

    //get hero by id
    suspend fun getHeroById(id: Long): Result<HeroCharacterResponse> {
        return try {
            val response = api.getHeroById(id)
            if (response.isSuccessful) {
                Result.Success(response.body() ?: throw Exception("Response body is null"))
            } else {
                Result.Error("Error: ${response.code()}")
            }
        } catch (e: Exception) {
            Result.Error(e.message ?: "Unknown error")
        }
    }

    //create the hero
    suspend fun createHero(request: HeroCharacterRequest): Result<HeroCharacterResponse> {
        return try {
            val response = api.createHero(request)
            if (response.isSuccessful) {
                Result.Success(response.body() ?: throw Exception("Response body is null"))
            } else {
                Result.Error("Error: ${response.code()}")
            }
        } catch (e: Exception) {
            Result.Error(e.message ?: "Unknown error")

        }
    }

    //update hero
    suspend fun updateHero(id: Long, request: HeroCharacterRequest): Result<HeroCharacterResponse> {
        return try {
            val response = api.updateHero(id, request)
            if (response.isSuccessful) {
                Result.Success(response.body() ?: throw Exception("Hero is not found"))
            } else {
                Result.Error("Error: ${response.code()}")
            }
        } catch (e: Exception) {
            Result.Error(e.message ?: "Unknow error")
        }
    }

    //delete hero
    suspend fun deleteHero(id: Long): Result<Unit> {
        return try {
            val response = api.deleteHero(id)
            if (response.isSuccessful) {
                Result.Success(Unit)
            } else {
                Result.Error("Error: ${response.code()}")
            }
        } catch (e: Exception) {
            Result.Error(e.message ?: "Unknow error")
        }

    }

}


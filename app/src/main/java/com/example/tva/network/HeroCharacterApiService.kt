package com.example.tva.network

import com.example.tva.model.HeroCharacterRequest
import com.example.tva.model.HeroCharacterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path


interface HeroCharacterApiService {

    //get all the hero
    @GET("hero")
    suspend fun getAllHero(): Response<List<HeroCharacterResponse>>

    //get hero by id
    @GET("hero/{id}")
    suspend fun getHeroById(
        @Path("id") id: Long
    ): Response<HeroCharacterResponse>

    //create hero
    @POST("hero")
    suspend fun createHero(
        @Body request: HeroCharacterRequest
    ): Response<HeroCharacterResponse>

    //update hero
    @PATCH("hero/{id}")
    suspend fun updateHero(
        @Path("id") id: Long,
        @Body request: HeroCharacterRequest
    ): Response<HeroCharacterResponse>


    //delete hero
    @DELETE("hero/{id}")
    suspend fun deleteHero(
        @Path("id") id: Long
    ): Response<HeroCharacterResponse>

}
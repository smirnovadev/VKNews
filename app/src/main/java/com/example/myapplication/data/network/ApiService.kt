package com.example.myapplication.data.network

import com.example.myapplication.data.model.NewsFeedResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("newsfeed.getRecommended?v=5.199")
    suspend fun loadRecommendation(
        @Query("access_token") token: String?
    ): NewsFeedResponseDto
}
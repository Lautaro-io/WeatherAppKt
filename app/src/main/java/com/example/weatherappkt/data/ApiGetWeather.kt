package com.example.weatherappkt.data

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiGetWeather {

    @GET("current.json")

    suspend fun getWeather(
        @Query("key")  key:String  = "928e9266acd34ebd98f142154240911",
        @Query("q") location :String
    ):WeatherDataResponse
}
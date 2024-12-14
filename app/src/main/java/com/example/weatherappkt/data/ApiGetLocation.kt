package com.example.weatherappkt.data

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiGetLocation {
    @GET ("json")
    suspend fun getCityLocation(
        @Query("q") name:String,
        @Query("key") apiKey:String = "6967ac32fe4d429e83ad5ce7f71938d8"
    ) : LocationResponse
}
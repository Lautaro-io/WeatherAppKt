package com.example.weatherappkt.data

import android.service.notification.Condition
import com.google.gson.annotations.SerializedName

data class WeatherDataResponse(
    @SerializedName("location") val location: LocationData,
    @SerializedName("current") val current: CurrentWeather
)

data class LocationData(
    @SerializedName("name") val cityName:String,
    @SerializedName("region") val region: String
)
data class CurrentWeather(
    @SerializedName("temp_c") val temp:Float,
    @SerializedName("condition") val condition:ConditionWeather,
    @SerializedName("wind_kph") val wind:Float,
    @SerializedName("humidity") val humidity:Int

)
data class ConditionWeather(
    @SerializedName("text") val condition: String,
    @SerializedName("icon") val icon: String
)
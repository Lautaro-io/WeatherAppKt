package com.example.weatherappkt.data

import com.google.gson.annotations.SerializedName

data class LocationResponse (
    @SerializedName("results") val data:List<GeometryResponse>
)
data class GeometryResponse(
    @SerializedName("geometry") val geometry:LatLon,
    @SerializedName("formatted") val name:String
)
data class LatLon(
    @SerializedName("lat") val latitud :Double,
    @SerializedName("lng") val longitud:Double
)

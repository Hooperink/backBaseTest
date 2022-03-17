package com.backbasetest.presentation.dvo

import com.google.gson.annotations.SerializedName


data class CitiesDvo(
    @SerializedName("country") val country: String,
    @SerializedName("name") val name: String,
    @SerializedName("_id") val _id: Int,
    @SerializedName("coord") val coord: CitiesCoordinateDvo
)

data class CitiesCoordinateDvo(
    @SerializedName("lon") val lon: Double,
    @SerializedName("lat") val lat: Double
)
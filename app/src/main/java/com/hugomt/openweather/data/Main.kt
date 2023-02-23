package com.hugomt.openweather.data

import com.google.gson.annotations.SerializedName

data class Main(
    @SerializedName("temp") val temp: Double,
    @SerializedName("humidity") val humidity: Double
)
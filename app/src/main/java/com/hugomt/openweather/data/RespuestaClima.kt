package com.hugomt.openweather.data

import com.google.gson.annotations.SerializedName


data class RespuestaClima(
    @SerializedName("main") val main: Main,
    @SerializedName("name") val name: String
) {
    fun aClima(): Clima {
        return Clima(
            temperatura = main.temp,
            humedad = main.humidity
        )
    }
}
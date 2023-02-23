package com.hugomt.openweather.repo

import com.hugomt.openweather.data.Clima


interface ClimaRepo {
    suspend fun obtenerClimaActual(ciudad: String, fecha:Long, claveApi: String): Clima
}
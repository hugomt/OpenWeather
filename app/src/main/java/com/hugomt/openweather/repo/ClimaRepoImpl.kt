package com.hugomt.openweather.repo

import com.hugomt.openweather.api.ServicioTiempo
import com.hugomt.openweather.data.Clima
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClimaRepoImpl : ClimaRepo {
    private val servicioClima: ServicioTiempo = Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org/data/2.5/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ServicioTiempo::class.java)

    override suspend fun obtenerClimaActual(ciudad: String, fecha:Long, claveApi: String): Clima {
        val respuesta = servicioClima.obtenerClimaActual(ciudad ,fecha, claveApi)
        return respuesta.aClima()
    }



}
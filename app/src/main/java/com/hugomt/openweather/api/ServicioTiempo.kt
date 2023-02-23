package com.hugomt.openweather.api
import com.hugomt.openweather.data.RespuestaClima

import retrofit2.http.GET
import retrofit2.http.Query

interface ServicioTiempo{
    @GET("weather")
    suspend fun obtenerClimaActual(
        @Query("q") ciudad: String,
        @Query("dt") date: Long,
        @Query("appid") claveApi: String,
        @Query("units") unidades: String = "metric"
    ): RespuestaClima


    /*@GET("forecast")
     suspend fun obtenerClimaPorDias(
         @Query("q") ciudad: String,
         @Query("appid") claveApi: String,
         @Query("units") unidades: String,
         @Query("lang") lang: String,
         @Query("cnt") count: Int
     ): ClimaPorDia*/

}
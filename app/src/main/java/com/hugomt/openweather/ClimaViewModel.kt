package com.hugomt.openweather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hugomt.openweather.data.Clima
import com.hugomt.openweather.repo.ClimaRepo
import kotlinx.coroutines.launch

class ClimaViewModel(private val climaRepository: ClimaRepo) : ViewModel() {
    val climaActual = MutableLiveData<Clima>()

    fun obtenerClima(ciudad: String, fecha:Long,  claveApi: String) {
        viewModelScope.launch {
            climaActual.value = climaRepository.obtenerClimaActual(ciudad, fecha, claveApi)
        }
    }


}
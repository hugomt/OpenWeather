package com.hugomt.openweather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hugomt.openweather.repo.ClimaRepo

class ClimaViewModelFactory(private val climaRepository: ClimaRepo) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ClimaViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ClimaViewModel(climaRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
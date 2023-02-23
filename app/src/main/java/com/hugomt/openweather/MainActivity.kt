package com.hugomt.openweather


import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.hugomt.openweather.repo.ClimaRepoImpl
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var climaViewModel: ClimaViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fechaActual = findViewById<TextView>(R.id.txtFecha)
        val formatoFecha = SimpleDateFormat("MMM dd, h:mma", Locale("en", "US"))
        val fecha = Date()
        fechaActual.text = formatoFecha.format(fecha)
        climaViewModel = ViewModelProvider(this, ClimaViewModelFactory(ClimaRepoImpl())).get(ClimaViewModel::class.java)
        actualizarClima("Torrelodones")


    }



        private fun actualizarClima(ciudad: String) {
            val calendar = Calendar.getInstance()
            calendar[Calendar.YEAR] = 2023
            calendar[Calendar.MONTH] = Calendar.FEBRUARY
            calendar[Calendar.DAY_OF_MONTH] = 22
            calendar[Calendar.HOUR_OF_DAY] = 22 // 02:00 PM en formato de 24 horas

            calendar[Calendar.MINUTE] = 30
            calendar[Calendar.SECOND] = 0
            val date = calendar.time
            val unixTimestamp = date.time / 1000L

            //formatoFecha.format(fecha)
        climaViewModel.obtenerClima(ciudad,unixTimestamp, "3a3e30e20ed76d924dd5e7f1b6730fb6")
        val ciudadTxt = findViewById<TextView>(R.id.txtCiudad)
        ciudadTxt.text = ciudad
    }



    @SuppressLint("SetTextI18n")
    override fun onStart() {
        super.onStart()
        climaViewModel.climaActual.observe(this) { clima ->
            val temperaturaTextView: TextView = findViewById(R.id.temperatura_actual_textview)
            val humedadTextView: TextView = findViewById(R.id.humedad_actual_textview)
            val img: ImageView = findViewById(R.id.imgTemp)
            if ( clima.temperatura <= 5){
                img.setImageResource(R.drawable.helado)
            }
            if (clima.temperatura > 5 && clima.temperatura <= 13){
                img.setImageResource(R.drawable.nublado)
            }
            if (clima.temperatura > 13 && clima.temperatura <= 24){
                img.setImageResource(R.drawable.mediosoleado)
            }
            if (clima.temperatura > 24){
                img.setImageResource(R.drawable.soleado)
            }

            var climaSinDecimales = clima.temperatura.toInt()
            temperaturaTextView.text = climaSinDecimales.toString() + "ºC"
            humedadTextView.text = clima.humedad.toString() + "%"
        }

    }
}
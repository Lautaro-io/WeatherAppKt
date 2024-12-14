package com.example.weatherappkt

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.weatherappkt.data.ApiGetWeather
import com.example.weatherappkt.databinding.ActivityWeatherDataBinding
import com.example.weatherappkt.databinding.ActivityWeatherMainBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherActivityData : AppCompatActivity() {
    private lateinit var binding: ActivityWeatherDataBinding

    private lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityWeatherDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = getWeatherRetrofit()
        var lat = intent.getDoubleExtra("LATITUD", 0.0)
        var lon = intent.getDoubleExtra("LONGITUD", 0.0)
        var location = "$lat,$lon"
        initUI(location)
    }

    private fun initUI(location:String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response =
                    retrofit.create(ApiGetWeather::class.java).getWeather(location = location)
                runOnUiThread {
                    binding.cityName.text = response.location.cityName
                    binding.cityLocation.text = response.location.region
                    val iconUrl = "https:${response.current.condition.icon}"
                    Picasso.get().load(iconUrl).into(binding.iconWeather)
                    val conditionInSpanish = when (response.current.condition.condition) {
                    "Clear" -> "Despejado"
                    "Partly cloudy" -> "Parcialmente nublado"
                    "Overcast" -> "Nublado"
                    "Rain" -> "Lluvia"
                    "Thunderstorm" -> "Tormenta"
                    "Snow" -> "Nieve"
                    "Fog" -> "Niebla"
                    "Hail" -> "Granizo"
                    "Mist" -> "Bruma"
                    else -> "Condición desconocida"
                }
                    binding.condition.text = conditionInSpanish
                    val temp = "${response.current.temp}°C"
                    binding.temp.text = temp
                }

            } catch (e: Exception) {
                Log.i("Chelo", "No se logro")
            }
        }
    }

    private fun getWeatherRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://api.weatherapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
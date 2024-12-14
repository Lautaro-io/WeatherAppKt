package com.example.weatherappkt

import android.R
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewParent
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SearchView
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.text.toLowerCase
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.weatherappkt.data.ApiGetLocation
import com.example.weatherappkt.data.GeometryResponse
import com.example.weatherappkt.databinding.ActivityWeatherMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class WeatherMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWeatherMainBinding
    private lateinit var retrofitLocation: Retrofit


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityWeatherMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofitLocation = getRetrofitLocation()
        initUI()
    }

    private fun initUI() {
        binding.svWeather.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                locationCity(query.orEmpty().trim().toLowerCase())

                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                return false
            }

        })
    }
    private var isSpinnerInitial = true

    private fun setupSpinner(spinner: Spinner, cityList: List<GeometryResponse>) {
        spinner.setSelection(-1,false)
        val cityNames = cityList.map { it.name }
        val adapter = ArrayAdapter(spinner.context, R.layout.simple_spinner_item, cityNames).apply {
            setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        }

        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {

                if (isSpinnerInitial) {
                    isSpinnerInitial = false
                    return
                }
                val selectedCity = cityList[position]
                val intent = Intent(this@WeatherMainActivity, WeatherActivityData::class.java)

                intent.putExtra("LONGITUD", selectedCity.geometry.longitud)
                intent.putExtra("LATITUD", selectedCity.geometry.latitud)
                startActivity(intent)
                return
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Log.i("Chelo", "Nothing")
            }
        }
    }

    private fun locationCity(name: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response =
                    retrofitLocation.create(ApiGetLocation::class.java).getCityLocation(name)
                runOnUiThread {
                    setupSpinner(
                        binding.spinnerCities, response.data
                    )
                }


            } catch (e: Exception) {
                Log.e("Chelo", "Error al obtener la ubicación: ${e.message}")
            }


        }
    }

    private fun getRetrofitLocation(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://api.opencagedata.com/geocode/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}
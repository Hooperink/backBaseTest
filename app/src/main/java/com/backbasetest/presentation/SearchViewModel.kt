package com.backbasetest.presentation

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.backbasetest.presentation.dvo.CitiesDvo
import com.backbasetest.presentation.util.CitySearchUtil
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

internal class SearchViewModel(
    context: Context,
    private val searchUtil: CitySearchUtil<CitiesDvo>
) : ViewModel() {

    private val _cities = MutableLiveData<List<CitiesDvo>>()
    val cities: LiveData<List<CitiesDvo>> get() = _cities

    private var savedCities: List<CitiesDvo>? = null

    init {
        val cities = getCities(context)
        val sortedCities =
            TreeSet<CitiesDvo>(compareBy({ it.name }, { it.country }, { it._id })).apply {
                addAll(cities)
            }
        savedCities = sortedCities.toList()
        savedCities?.let(_cities::setValue)
    }

    fun search(search: String) {
        savedCities?.let {
            _cities.value = searchUtil.searchByPrefix(search, it)
        }
    }

    private fun getCities(context: Context): List<CitiesDvo> {
        val jsonString =
            context.assets.open(CITIES_PATH).bufferedReader().use { it.readText() }
        return Gson().fromJson(jsonString, object : TypeToken<Collection<CitiesDvo>>() {}.type)
    }

    companion object {
        private const val CITIES_PATH = "cities/cities.json"
    }
}
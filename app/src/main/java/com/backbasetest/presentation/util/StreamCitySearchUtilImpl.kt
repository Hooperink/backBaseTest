package com.backbasetest.presentation.util

import com.backbasetest.presentation.dvo.CitiesDvo
import java.util.stream.Collectors

internal class StreamCitySearchUtilImpl : CitySearchUtil<CitiesDvo> {

    /**
    This search method can be a good alternative for linear search because of parallel streams (improved performance).
    It will work even list is not sorted.
    Search is based on city names [CitiesDvo.name]
     */
    override fun searchByPrefix(prefix: String, list: List<CitiesDvo>): List<CitiesDvo> {
        return list.stream().parallel().filter {
            it.name.startsWith(prefix, true)
        }.collect(Collectors.toList())
    }
}
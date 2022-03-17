package com.backbasetest.presentation.util

interface CitySearchUtil<T> {
    fun searchByPrefix(prefix: String, list: List<T>): List<T>
}
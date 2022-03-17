package com.backbasetest.presentation.di

import com.backbasetest.presentation.SearchViewModel
import com.backbasetest.presentation.dvo.CitiesDvo
import com.backbasetest.presentation.util.BinaryCitySearchUtilImpl
import com.backbasetest.presentation.util.CitySearchUtil
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { SearchViewModel(androidContext(), get()) }
    single<CitySearchUtil<CitiesDvo>> { BinaryCitySearchUtilImpl() }
}
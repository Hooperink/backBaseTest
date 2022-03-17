package com.backbasetest.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.backbasetest.R
import com.backbasetest.databinding.MainFragmentBinding
import com.backbasetest.presentation.base.BaseDelegateFragment
import com.backbasetest.presentation.dvo.CitiesDvo
import com.backbasetest.presentation.recycler.adapter.CitiesAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.ext.getFullName

internal class SearchFragment : BaseDelegateFragment<MainFragmentBinding>() {

    companion object {
        fun newInstance() = SearchFragment()
    }

    override val layoutId: Int = R.layout.main_fragment

    override fun bindView(view: View): MainFragmentBinding = MainFragmentBinding.bind(view)

    private val searchViewModel: SearchViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.run {
            initUi()
            rvCities.apply {
                layoutManager = LinearLayoutManager(requireContext())
            }
            searchViewModel.cities.observe(viewLifecycleOwner) {
                rvCities.adapter = CitiesAdapter(::navigateToMap, it)
            }
        }

    }

    private fun initUi() {
        viewBinding.run {
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(p0: String?) = false
                override fun onQueryTextChange(p0: String?): Boolean {
                    p0?.let { searchViewModel.search(it) }
                    return false
                }
            })
        }
    }

    private fun navigateToMap(citiesDvo: CitiesDvo) {
        requireActivity().supportFragmentManager.beginTransaction().apply {
            addToBackStack(MapsFragment::class.getFullName())
            add(R.id.container, MapsFragment.newInstance(citiesDvo.coord.lat, citiesDvo.coord.lon))
            commit()
        }
    }

}
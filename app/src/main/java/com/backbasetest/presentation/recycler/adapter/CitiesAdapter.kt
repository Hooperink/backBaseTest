package com.backbasetest.presentation.recycler.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.backbasetest.presentation.dvo.CitiesDvo
import com.backbasetest.presentation.recycler.view_holder.CitiesViewHolder

internal class CitiesAdapter(
    private val onClick: (item: CitiesDvo) -> Unit,
    private val citiesList: List<CitiesDvo>
) : RecyclerView.Adapter<CitiesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitiesViewHolder {
        return CitiesViewHolder.newInstance(parent, onClick)
    }

    override fun onBindViewHolder(holder: CitiesViewHolder, position: Int) =
        holder.bind(citiesList[position])

    override fun getItemCount() = citiesList.size

}
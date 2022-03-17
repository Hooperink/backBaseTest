package com.backbasetest.presentation.recycler.view_holder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.backbasetest.databinding.CitiesViewHolderBinding
import com.backbasetest.presentation.dvo.CitiesDvo

internal class CitiesViewHolder private constructor(
    private val binding: CitiesViewHolderBinding,
    private val onClick: (item: CitiesDvo) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: CitiesDvo) {
        binding.run {
            tvCitiesTitle.text = item.name
            tvCountryTitle.text = item.country
            tvCoordinatesLatitudeSubTitle.text = item.coord.lat.toString()
            tvCoordinatesLongitudeSubTitle.text = item.coord.lon.toString()
            binding.root.setOnClickListener {
                onClick(item)
            }
        }
    }

    companion object {
        fun newInstance(parent: ViewGroup, onClick: (item: CitiesDvo) -> Unit) =
            CitiesViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                .run {
                    CitiesViewHolder(this, onClick)
                }
    }
}
package com.backbasetest.presentation

import android.os.Bundle
import android.view.View
import com.backbasetest.R
import com.backbasetest.databinding.FragmentMapsBinding
import com.backbasetest.presentation.base.BaseDelegateFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

internal class MapsFragment : BaseDelegateFragment<FragmentMapsBinding>() {

    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        val position =
            LatLng(arguments?.getDouble(LATITUDE) ?: 0.0, arguments?.getDouble(LONGITUDE) ?: 0.0)
        googleMap.addMarker(MarkerOptions().position(position))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(position))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

    override val layoutId: Int = R.layout.fragment_maps

    override fun bindView(view: View): FragmentMapsBinding = FragmentMapsBinding.bind(view)

    companion object {
        private const val LATITUDE = "latitude"
        private const val LONGITUDE = "longitude"

        fun newInstance(lat: Double, lon: Double) = MapsFragment().apply {
            arguments = Bundle().apply {
                putDouble(LATITUDE, lat)
                putDouble(LONGITUDE, lon)
            }
        }
    }

}
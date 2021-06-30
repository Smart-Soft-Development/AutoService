package com.example.autoservice.AppMap

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import com.example.autoservice.R
import com.example.autoservice.databinding.FragmentMapsBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment(R.layout.fragment_maps),GoogleMap.OnMarkerClickListener{
    private var _binding :FragmentMapsBinding?=null
    private lateinit var lastlocation:Location
    private  val Location_request_code = 1
    private lateinit var map:GoogleMap
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private val binding get() = _binding!!
    private val callback = OnMapReadyCallback { googleMap ->
        map = googleMap
        map.uiSettings.isZoomControlsEnabled = true
        map.setOnMarkerClickListener(this)

        setupmap()

        val sydney = LatLng(-34.0, 151.0)
        map.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        map.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMapsBinding.bind(view)
        fusedLocationProviderClient =LocationServices.getFusedLocationProviderClient(binding.root.context)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?

        mapFragment?.getMapAsync(callback)
    }



    private fun setupmap() {
        if (ActivityCompat.checkSelfPermission(
                binding.root.context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                binding.root.context,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),Location_request_code)
            return
        }
        map.isMyLocationEnabled = true
        fusedLocationProviderClient.lastLocation.addOnSuccessListener(requireActivity()){
                loc ->
            if (loc !=null){
                lastlocation = loc
                val currentlanglat = LatLng(loc.latitude,loc.longitude)
                placemarekermap(currentlanglat)
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(currentlanglat,12f))
            }
        }
    }

    private fun placemarekermap(currentlanglat:LatLng){
        var markeroption = MarkerOptions().position(currentlanglat)
        markeroption.title("$currentlanglat") // izoh
        map.addMarker(markeroption)
    }

    override fun onMarkerClick(p0: Marker?)=false



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
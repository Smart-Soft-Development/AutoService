package com.example.autoservice

import android.content.pm.PackageManager
import android.location.Location
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.navigation.fragment.findNavController
import com.example.autoservice.databinding.FragmentMapsBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment(R.layout.fragment_maps) {
    private var _binding:FragmentMapsBinding?=null
    private val binding get() = _binding
    private lateinit var map:GoogleMap
    private lateinit var lastlocation:Location

    lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMapsBinding.bind(view)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(binding?.root?.context)
         val callback = OnMapReadyCallback { googleMap ->
            /**
             * Manipulates the map once available.
             * This callback is triggered when the map is ready to be used.
             * This is where we can add markers or lines, add listeners or move the camera.
             * In this case, we just add a marker near Sydney, Australia.
             * If Google Play services is not installed on the device, the user will be prompted to
             * install it inside the SupportMapFragment. This method will only be triggered once the
             * user has installed Google Play services and returned to the app.
             */
             if (ActivityCompat.checkSelfPermission(binding?.root?.context!!,android.Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED &&
                 ActivityCompat.checkSelfPermission(binding?.root?.context!!,android.Manifest.permission.ACCESS_COARSE_LOCATION) !=PackageManager.PERMISSION_GRANTED){
                 ActivityCompat.requestPermissions(this.requireActivity(), arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),101)

             }
//             fusedLocationProviderClient.lastLocation
//                 .addOnSuccessListener { location : Location? ->
//                     // Got last known location. In some rare situations this can be null.
                     val chilonzor = LatLng(41.27437363664406, 69.2048837600789)
//                     Log.e("MAIN", "onViewCreated: ${location?.latitude!!}, ${location.longitude}", )
//
//                     val livespace = LatLng(location?.latitude!!, location.longitude)

//                     googleMap.addMarker(MarkerOptions().position(livespace).title("Tashkent Uzbekistan Oybek metro"))
                     googleMap.addMarker(MarkerOptions().position(chilonzor).title("Tashkent Uzbekistan Chilonzro metro"))
                     googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(chilonzor,15f))
//                 }
             fusedLocationProviderClient.lastLocation.addOnSuccessListener {
                 if (it !=null){
                     lastlocation = it
                     var currentlatlang = LatLng(it.latitude,it.longitude)

                     map.animateCamera(CameraUpdateFactory.newLatLngZoom(currentlatlang,15f))
                 }
             }
        }
        mapFragment?.getMapAsync(callback)

        binding?.back?.setOnClickListener {
            findNavController().popBackStack()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
package com.example.autoservice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.autoservice.databinding.FragmentSoSBinding


class SoSFragment : Fragment(R.layout.fragment_so_s) {

    private var _binding:FragmentSoSBinding?=null
    private val binding get() = _binding!!



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentSoSBinding.bind(view)

        binding.sosbtn.setOnClickListener{
            findNavController().navigate(R.id.mapsFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
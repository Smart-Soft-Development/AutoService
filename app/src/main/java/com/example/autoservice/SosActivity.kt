package com.example.autoservice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import com.example.autoservice.databinding.ActivitySosBinding

class SosActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySosBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this,R.id.nav_graph_sos).navigateUp()
    }
}
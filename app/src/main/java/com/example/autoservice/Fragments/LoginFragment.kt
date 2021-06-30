package com.example.autoservice.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.autoservice.R
import com.example.autoservice.SosActivity
import com.example.autoservice.databinding.FragmentLoginBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment(R.layout.fragment_login) {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding:FragmentLoginBinding?=null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentLoginBinding.bind(view)
        binding.logintoregistration.setOnClickListener {
            findNavController().popBackStack()
            findNavController().navigate(R.id.homeFragment)
        }
        binding.logintoforgot.setOnClickListener {
            findNavController().popBackStack()
            findNavController().navigate(R.id.homeFragment)
        }
        binding.next.setOnClickListener {
            val passsword = binding.loginpassword.text.toString()
            val phonenumber = binding.loginphonenumber.text.toString()
            if (passsword.length >= 8 && phonenumber[0] == '+'){
               //findNavController().popBackStack()
                var intent = Intent(activity,SosActivity::class.java)
                startActivity(intent)
                activity?.finish()
            }

        }
    }
    fun tes() {

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
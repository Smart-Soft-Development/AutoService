package com.example.autoservice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.autoservice.databinding.FragmentAdminRegistrationBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class AdminRegistrationFragment : Fragment(R.layout.fragment_admin_registration) {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding:FragmentAdminRegistrationBinding?=null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentAdminRegistrationBinding.bind(view)
        binding.signupBtnUser.setOnClickListener{
            val firstname = binding.firstname.text.toString()
            val lastnmae = binding.lastename.text.toString()

            val phonenumber = binding.phonenumber.text.toString()
            val password = binding.password.text.toString()
            val confirmpassword = binding.confirmpassword.text.toString()

            if (phonenumber[0] == '+' && password.length >=8 && confirmpassword.length >=8 && password == confirmpassword && firstname.isNotEmpty()&&lastnmae.isNotEmpty()){

            }
        }
        binding.registertogologin.setOnClickListener {
            findNavController().popBackStack()
            findNavController().navigate(R.id.loginFragment)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_admin_registration, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AdminRegistrationFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AdminRegistrationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
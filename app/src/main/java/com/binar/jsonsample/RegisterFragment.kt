package com.binar.jsonsample

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.binar.jsonsample.Presenter.RegisterContract
import com.binar.jsonsample.Presenter.RegisterPresenter
import com.binar.jsonsample.data.AdminRegister
import com.binar.jsonsample.databinding.FragmentRegisterBinding
import com.binar.jsonsample.model.RegisterResponseItem
import com.binar.jsonsample.service.ApiClient
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterFragment : Fragment(),RegisterContract.viewInterface {
    private var _binding : FragmentRegisterBinding?=null
    private val binding : FragmentRegisterBinding get() = _binding!!
    private var presenter = RegisterPresenter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentRegisterBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.registerButton.setOnClickListener {
            val adminRegister= AdminRegister(
                email = binding.emailEditText.text.toString(),
                password = binding.passwordEditText.text.toString(),
                role = "admin"
            )
            presenter.registerAdmin(adminRegister)
        }

    }

    override fun resultCode(code: Int) {
        if(code == 201){
            Toast.makeText(requireContext(),"Register Sucess",Toast.LENGTH_SHORT).show()
            findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToHomeFragment())
        }else if(code == 400){
            Toast.makeText(requireContext(),"Email Already Exists",Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(requireContext(),"Password Must At Least 6 Char or invalid email",Toast.LENGTH_SHORT).show()
        }
    }

}
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
import com.binar.jsonsample.data.AdminRegister
import com.binar.jsonsample.databinding.FragmentRegisterBinding
import com.binar.jsonsample.model.RegisterResponseItem
import com.binar.jsonsample.service.ApiClient
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterFragment : Fragment() {
    private var _binding : FragmentRegisterBinding?=null
    private val binding : FragmentRegisterBinding get() = _binding!!

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
            ApiClient.instance.regsiterAdmin(adminRegister)
                .enqueue(object  : Callback<RegisterResponseItem> {
                    override fun onResponse(
                        call: Call<RegisterResponseItem>,
                        response: Response<RegisterResponseItem>
                    ) {
                        binding.progressBar.visibility = View.VISIBLE
                        if (TextUtils.isEmpty(adminRegister.email) || TextUtils.isEmpty(
                                adminRegister.password
                            )
                        ) {
                            Toast.makeText(
                                requireContext(),
                                "Pleas fill all fields",
                                Toast.LENGTH_LONG
                            ).show()
                            binding.progressBar.visibility = View.GONE
                        } else {
                            val code = response.code()
                            val message = response.message().toString()
                            if (code == 201) {
                                Toast.makeText(
                                    requireContext(),
                                    "Register Success",
                                    Toast.LENGTH_LONG
                                ).show()
                                binding.progressBar.visibility = View.GONE
                                findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToHomeFragment())
                            } else if (code == 500) {
                                Toast.makeText(
                                    requireContext(),
                                    "Register failed ,Password must at least 6 character or input valid email",
                                    Toast.LENGTH_LONG
                                ).show()
                                binding.progressBar.visibility = View.GONE
                            }else{
                                Toast.makeText(
                                    requireContext(),
                                    "Register failed, Email Already Exists",
                                    Toast.LENGTH_LONG
                                ).show()
                                binding.progressBar.visibility = View.GONE
                            }

                            Log.d("sucess", response.body().toString())
                        }
                    }

                    override fun onFailure(call: Call<RegisterResponseItem>, t: Throwable) {
                        Log.d("fail", t.message.toString())
                        binding.progressBar.visibility = View.GONE
                    }

                })


        }

    }

}
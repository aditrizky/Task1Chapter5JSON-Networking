package com.binar.jsonsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.binar.jsonsample.Presenter.SignInContract
import com.binar.jsonsample.Presenter.SignInPresenter
import com.binar.jsonsample.data.LoginAdmin
import com.binar.jsonsample.databinding.FragmentLoginBinding
import com.binar.jsonsample.databinding.FragmentRegisterBinding
import com.binar.jsonsample.model.AdminLoginResponse
import com.binar.jsonsample.service.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.format.SignStyle


class LoginFragment : Fragment(),SignInContract.viewInterface {
    private var _binding : FragmentLoginBinding?=null
    private val binding : FragmentLoginBinding get() = _binding!!
    private var presenter = SignInPresenter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginButton.setOnClickListener {
            val loginAdmin = LoginAdmin(
                email = binding.emailLoginEditText.text.toString(),
                password = binding.passwordLoginEditText.text.toString()
            )
            presenter.signIn(loginAdmin)
        }
    }

    override fun resultCode(code: Int) {
        if(code == 201){
            Toast.makeText(requireContext(),"Login Sucess",Toast.LENGTH_SHORT).show()
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHomeFragment())
        }else if(code == 400){
            Toast.makeText(requireContext(),"Password Was Wrong",Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(requireContext(),"Email Not Found",Toast.LENGTH_SHORT).show()
        }
    }

}
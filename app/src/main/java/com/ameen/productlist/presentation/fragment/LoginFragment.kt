package com.ameen.productlist.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ameen.productlist.R
import com.ameen.productlist.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val loginViewModel: LoginViewModel by viewModels()

    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        FragmentLoginBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        initView()

        return binding.root
    }

    private fun initView() {
        binding.loginButton.setOnClickListener {
            checkLogin()
        }
    }

    private fun checkLogin() {
        val result = loginViewModel.loginUsernameAndPassword(
            binding.phoneNumberText.text.toString(),
            binding.passwordText.text.toString()
        )

        if (result) {
            val action = LoginFragmentDirections.actionLoginFragmentToHomeFragment()
            findNavController().navigate(action)
        } else {
            Toast.makeText(
                requireContext(),
                "Phone must be 11 digit and password more than 8 chars.", Toast.LENGTH_SHORT
            ).show()
        }
    }

}
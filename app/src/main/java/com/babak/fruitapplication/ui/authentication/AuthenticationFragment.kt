package com.babak.fruitapplication.ui.authentication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.babak.fruitapplication.R
import com.babak.fruitapplication.base.BaseFragment
import com.babak.fruitapplication.databinding.FragmentAuthenticationBinding


class AuthenticationFragment :BaseFragment<FragmentAuthenticationBinding>(FragmentAuthenticationBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigateToHome()
    }

    fun navigateToHome(){
        binding.startOrdering.setOnClickListener {
            val name = binding.authInput.text.toString().trim()
            if(name.isNotEmpty()){
                findNavController().navigate(AuthenticationFragmentDirections.actionAuthenticationFragmentToHomeFragment(name))
            }else{
                Toast.makeText(context,"Adinizi yazin",Toast.LENGTH_LONG).show()
            }
        }

    }
}
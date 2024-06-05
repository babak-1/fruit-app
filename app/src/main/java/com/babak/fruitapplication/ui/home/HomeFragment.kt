package com.babak.fruitapplication.ui.home

import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.babak.fruitapplication.R
import com.babak.fruitapplication.base.BaseFragment
import com.babak.fruitapplication.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment :BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private val viewModel by viewModels<HomeViewModel>()
    var adapter = ProductsAdapter()
    val args:HomeFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val greeting="Hello ${args.name}, <b>What fruit salad combo do you want today?</b>"
        binding.username.text=Html.fromHtml(greeting,Html.FROM_HTML_MODE_LEGACY)
        binding.rvProducts.adapter=adapter
        observData()
        viewModel.getData()
    }

    fun observData(){
        viewModel.products.observe(viewLifecycleOwner){
            if (it != null) {
                adapter.updateList(it)
            }
        }
    }
}
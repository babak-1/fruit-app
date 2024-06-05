package com.babak.fruitapplication.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.babak.fruitapplication.ProductsRepository
import com.babak.fruitapplication.model.ProductResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(private val repo:ProductsRepository):ViewModel() {
    val products = MutableLiveData<List<ProductResponse>?>()
    val error = MutableLiveData<String>()
    val loading =MutableLiveData<Boolean>()

    fun getData(){
        loading.value=true
        viewModelScope.launch() {
            try {
                val response = repo.getAllProducts()
                if (response.isSuccessful){
                       val res = response.body()
                      products.value=res
                }
            }catch (e:Exception){

            }
        }
    }
}
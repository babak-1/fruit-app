package com.babak.fruitapplication.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.babak.fruitapplication.databinding.CardItemBinding
import com.babak.fruitapplication.model.ProductResponse
import com.babak.fruitapplication.utils.imageLoad

class ProductsAdapter : RecyclerView.Adapter<ProductsAdapter.ProductAdapterViewHolder>() {
    private val list = arrayListOf<ProductResponse>()

    inner class ProductAdapterViewHolder(val cardItemBinding: CardItemBinding) :
        RecyclerView.ViewHolder(cardItemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapterViewHolder {
        val view = CardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductAdapterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ProductAdapterViewHolder, position: Int) {
        val item = list[position]
        holder.cardItemBinding.cardName.text = item.productName
        holder.cardItemBinding.cardPrice.text = item.productPrice
        holder.cardItemBinding.cardImage.imageLoad(item.productImage)
    }

    fun updateList(newList: List<ProductResponse>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
}


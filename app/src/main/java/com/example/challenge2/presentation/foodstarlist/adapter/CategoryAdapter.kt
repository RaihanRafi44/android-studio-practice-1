package com.example.challenge2.presentation.foodstarlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challenge2.databinding.ItemCategoryBinding
import com.example.challenge2.data.model.Category

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>(){

    private val data = mutableListOf<Category>()

    fun submitData(items: List<Category>){
        data.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(ItemCategoryBinding.inflate
            (LayoutInflater.from(parent.context),
            parent,
            false))

    }

    //Counting the data size
    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(data[position])
    }

    class CategoryViewHolder(private val binding : ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root){
        fun bind(item : Category){
            binding.tvCategoryName.text = item.name
            binding.ivCategoryImages.setImageResource(item.image)

        }
    }


}
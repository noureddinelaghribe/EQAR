package com.noureddine.eqar.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.noureddine.eqar.Model.SliderItem
import com.noureddine.eqar.databinding.ItemSliderBinding

class SliderAdapter(private val items: List<SliderItem>) :
    RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {

    inner class SliderViewHolder(private val binding: ItemSliderBinding) : 
        RecyclerView.ViewHolder(binding.root) {
        
        fun bind(item: SliderItem) {
            binding.ivSliderImage.setImageResource(item.imageRes)
            binding.tvSliderTitle.text = item.title
            binding.tvSliderDescription.text = item.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        val binding = ItemSliderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SliderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
} 
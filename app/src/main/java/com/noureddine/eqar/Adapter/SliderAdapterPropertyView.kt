package com.noureddine.eqar.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.noureddine.eqar.databinding.ItemSliderPropertyViewBinding

class SliderAdapterPropertyView(private val items: List<String>) :
    RecyclerView.Adapter<SliderAdapterPropertyView.SliderViewHolder>() {

    inner class SliderViewHolder(private val binding: ItemSliderPropertyViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: String) {
            binding.ivSliderImage.setImageResource(item.toInt())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderAdapterPropertyView.SliderViewHolder {
        val binding = ItemSliderPropertyViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SliderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SliderAdapterPropertyView.SliderViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size


}
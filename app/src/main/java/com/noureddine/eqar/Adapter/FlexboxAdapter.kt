package com.noureddine.eqar.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.noureddine.eqar.databinding.ItemDocumentBinding
import com.noureddine.eqar.databinding.ItemFeatureBinding

class FlexboxAdapter(private val items: List<String>, private val isFeature: Boolean = true) : 
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return if (isFeature) 1 else 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            1 -> {
                val binding = ItemFeatureBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                FeatureViewHolder(binding)
            }
            2 -> {
                val binding = ItemDocumentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                DocumentViewHolder(binding)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is FeatureViewHolder -> holder.bind(items[position])
            is DocumentViewHolder -> holder.bind(items[position])
        }
    }

    override fun getItemCount(): Int = items.size

    inner class FeatureViewHolder(private val binding: ItemFeatureBinding) : 
        RecyclerView.ViewHolder(binding.root) {
        fun bind(feature: String) {
            binding.chipFeature.text = feature
        }
    }

    inner class DocumentViewHolder(private val binding: ItemDocumentBinding) : 
        RecyclerView.ViewHolder(binding.root) {
        fun bind(document: String) {
            binding.chipDocument.text = document
        }
    }
}

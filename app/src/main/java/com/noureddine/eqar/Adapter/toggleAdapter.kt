package com.noureddine.eqar.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.noureddine.eqar.Model.ToggleBtn
import com.noureddine.eqar.databinding.ItemToggleBinding

class toggleAdapter (private val items: List<ToggleBtn>): RecyclerView.Adapter<toggleAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemToggleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(private val binding: ItemToggleBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ToggleBtn) {
            binding.toggleBtn.textOn = item.text
            binding.toggleBtn.textOff = item.text
            binding.toggleBtn.isChecked = item.ischecked
        }
    }

}
package com.noureddine.eqar.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.noureddine.eqar.Model.PropertyItem
import com.noureddine.eqar.R
import com.noureddine.eqar.databinding.ItemPropertyBinding
import com.noureddine.eqar.utils.Constants
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
class PropertyAdapter(
    private val items: List<PropertyItem>,
    private val onItemClick: (PropertyItem) -> Unit,
    private val onFavoriteClick: (PropertyItem) -> Unit
) : RecyclerView.Adapter<PropertyAdapter.PropertyViewHolder>() {

    inner class PropertyViewHolder(private val binding: ItemPropertyBinding) : 
        RecyclerView.ViewHolder(binding.root) {
        
        @SuppressLint("SetTextI18n")
        fun bind(item: PropertyItem) {
            binding.apply {
                // تعيين البيانات الأساسية
                tvTitle.text = Constants.PropertyName.get(item.typeProperty) +" "+Constants.PropertyTypeName.get(item.type)
                //tvDescription.text = item.description
                if (item.price>1){
                    tvPrice.text = Constants.formatWithCommas(item.price)
                }else{
                    tvPrice.text = "حسب الاتفاق"
                }

                val wilaya = Constants.wilayasFr.get(item.location.get(0))
                val baladias = Constants.wilayaToBaladiasAr[wilaya]
                val baladia = baladias?.get(item.location.get(1))  // This will give you "Tamentit"
                tvLocation.text = wilaya+", "+baladia

                ivPropertyImage.setImageResource(item.imageRes.get(0).toInt())

                // تعيين نوع العقار (كراء، بيع، تبادل)
                //tvPropertyType.text = item.type
//                tvPropertyType.setBackgroundColor(
//                    when(item.type) {
//                        "كراء" -> ContextCompat.getColor(root.context, R.color.primary_blue)
//                        "بيع" -> ContextCompat.getColor(root.context, R.color.primary_green)
//                        else -> ContextCompat.getColor(root.context, R.color.accent_teal)
//                    }
//                )

                // تعيين حالة المفضلة
//                ivFavorite.setImageResource(
//                    if (item.isFavorite) R.drawable.ic_favorite_filled
//                    else R.drawable.ic_favorite_border
//                )

//                ivFavorite.iconsetImageResource(R.drawable.ic_favorite_border)
//                ivFavorite.setColorFilter(
//                    if (item.isFavorite) ContextCompat.getColor(root.context, R.color.accent_red)
//                    else ContextCompat.getColor(root.context, R.color.gray_3)
//                )

                // Configure FlexboxLayoutManager
                val flexboxLayoutManager = FlexboxLayoutManager(binding.root.context).apply {
                    flexDirection = FlexDirection.ROW
                    flexWrap = FlexWrap.WRAP
                    justifyContent = com.google.android.flexbox.JustifyContent.FLEX_START
                }

                val features = mutableListOf<String>()
                for (i in item.features){
                    features.add(Constants.FeatureIdsName.get(i))
                }

                // Set up RecyclerView
                binding.FeatureRecyclerView.apply {
                    layoutManager = flexboxLayoutManager
                    adapter = FlexboxAdapter(features,true)
                }


                // إعداد مستمعي النقر
                root.setOnClickListener {
                    onItemClick(item)
                }
                ivFavorite.setOnClickListener {
                    ivFavorite.setImageResource(
                        R.drawable.ic_favorite
                    )
                    ivFavorite.setColorFilter(ContextCompat.getColor(root.context, R.color.accent_red))
                    onFavoriteClick(item)
                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PropertyViewHolder {
        val binding = ItemPropertyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PropertyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PropertyViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
} 
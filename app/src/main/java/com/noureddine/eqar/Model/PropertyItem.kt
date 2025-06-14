package com.noureddine.eqar.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.sql.Timestamp

@Parcelize
data class PropertyItem(
    val id: String,
    val timestamp: Long,
    val typeProperty: Int,
    val startRent: Long,
    val description: String,
    val price: Long,
    val rentByMonth: Boolean = false,
    val minumRent: Int,
    val floorNumber: Int,
    val Area: Int,
    val location: List<Int> = listOf(),
    val locationMap: String,
    val imageRes: List<String> = listOf(),
    val documents: List<Int> = listOf(),
    val type: Int, // 2-كراء، 1-بيع، 3-تبادل
    val typePay: Int, //1-بالتقسيط 2-الائتمان البنكي 3-وعد بالبيع 4-نقداً
    val linkVideo: String,
    val features: List<Int> = listOf(), // مميزات العقار
    val isFavorite: Boolean = false,
    val isNegotiate: Boolean = false,
    val isEquipped: Boolean = false
) : Parcelable
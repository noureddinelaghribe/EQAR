package com.noureddine.eqar.Model

import java.io.Serializable

data class OnboardingItem(
    val imageRes: Int,
    val title: String,
    val description: String
) : Serializable

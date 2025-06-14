package com.noureddine.eqar.Model

import java.util.Date

data class ChatMessage(
    val message: String,
    val isFromUser: Boolean,
    val timestamp: Date = Date()
)
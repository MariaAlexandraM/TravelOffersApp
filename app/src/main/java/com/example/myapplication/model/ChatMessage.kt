package com.example.myapplication.model

data class ChatMessage(val id: Int,
    val sender: String,
    val message: String,
    val timestamp: String,
    val isSelected: Boolean = false
    )

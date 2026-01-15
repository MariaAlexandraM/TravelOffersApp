package com.example.myapplication.model

import java.io.Serializable

data class Offer (
    val id: Int,
    val title: String,
    val description: String,
    val price: Int,
    val currency: String,
    val picture: Int
): Serializable
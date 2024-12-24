package com.example.astroshopenligne.activities


data class ItemShop(
    val id: Int,
    val title: String,
    val price: String,
    val rating: String,
    val imageResId: Int,
    val buttonResId: Int,
    val description: String,
    var quantity: Int,
    var isfavorite: Boolean = false
)

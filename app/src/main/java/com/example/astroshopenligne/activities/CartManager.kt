package com.example.astroshopenligne.activities

object CartManager {
    private val cartItems = mutableListOf<ItemShop>()

    fun addToCart(item: ItemShop) {
        cartItems.add(item)
    }

    fun getCartItems(): List<ItemShop> {
        return cartItems
    }

    fun removeFromCart(item: ItemShop) {
        cartItems.remove(item)
    }

    fun clearCart() {
        cartItems.clear()
    }
}


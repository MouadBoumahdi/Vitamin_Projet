package com.example.astroshopenligne.activities

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.astroshopenligne.R

class CartActivity : AppCompatActivity() {

    private lateinit var cartRecyclerView: RecyclerView
    private lateinit var emptyCartMessage: TextView
    private lateinit var totalTextView: TextView
    private lateinit var adapter: CartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

         cartRecyclerView = findViewById(R.id.cartRecyclerView)
        emptyCartMessage = findViewById(R.id.emptyCartMessage)
        totalTextView = findViewById(R.id.totalTxt)

        // Fetch cart items from CartManager
        val cartItems = CartManager.getCartItems()

         if (cartItems.isNullOrEmpty()) {
            toggleEmptyCartMessage(true)
        } else {
             adapter = CartAdapter(cartItems) { item ->
                removeFromCart(item)
            }
            cartRecyclerView.layoutManager = LinearLayoutManager(this)
            cartRecyclerView.adapter = adapter

             updateTotalPrice(cartItems)
            toggleEmptyCartMessage(false)
        }
    }

    private fun removeFromCart(item: ItemShop) {
        CartManager.removeFromCart(item)
        val updatedCartItems = CartManager.getCartItems()
        adapter.updateItems(updatedCartItems)
        toggleEmptyCartMessage(updatedCartItems.isEmpty())
        Toast.makeText(this, "${item.title} removed from cart", Toast.LENGTH_SHORT).show()

         updateTotalPrice(updatedCartItems)
    }

    private fun toggleEmptyCartMessage(isEmpty: Boolean) {
        if (isEmpty) {
            emptyCartMessage.visibility = TextView.VISIBLE
            cartRecyclerView.visibility = RecyclerView.GONE
        } else {
            emptyCartMessage.visibility = TextView.GONE
            cartRecyclerView.visibility = RecyclerView.VISIBLE
        }
    }

    private fun updateTotalPrice(cartItems: List<ItemShop>) {
        var total = 0.0

         for (item in cartItems) {
             val itemPrice = item.price.replace(Regex("[^0-9.]"), "").toDoubleOrNull() ?: 0.0

             total += itemPrice * item.quantity
        }

         findViewById<TextView>(R.id.totalTxt).text = "Total: $${"%.2f".format(total)}"
    }
}

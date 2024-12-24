package com.example.astroshopenligne.activities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.astroshopenligne.R

class CartAdapter(
    private var cartItems: List<ItemShop>,
    private val removeItemCallback: (ItemShop) -> Unit
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cart, parent, false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val item = cartItems[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return cartItems.size
    }

    fun updateItems(newItems: List<ItemShop>) {
        cartItems = newItems
        notifyDataSetChanged()
    }

    inner class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemImage: ImageView = itemView.findViewById(R.id.itemImage)
        private val itemTitle: TextView = itemView.findViewById(R.id.itemTitle)
        private val itemPrice: TextView = itemView.findViewById(R.id.itemPrice)
        private val removeButton: Button = itemView.findViewById(R.id.removeButton)

        fun bind(item: ItemShop) {
            itemImage.setImageResource(item.imageResId)
            itemTitle.text = item.title
            itemPrice.text = item.price

             removeButton.setOnClickListener {
                removeItemCallback(item)
            }
        }
    }
}

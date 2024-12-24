package com.example.astroshopenligne.activities

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.astroshopenligne.R

class ItemShopAdapter(private val itemList: List<ItemShop>) :
    RecyclerView.Adapter<ItemShopAdapter.ItemShopViewHolder>() {

    inner class ItemShopViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pic: ImageView = itemView.findViewById(R.id.pic)
        val titleTxt: TextView = itemView.findViewById(R.id.titleTxt)
        val priceTxt: TextView = itemView.findViewById(R.id.priceTxt)
        val ratingTxt: TextView = itemView.findViewById(R.id.ratingTxt)
        val imvStart: ImageView = itemView.findViewById(R.id.imvStart)
        val imvBtn: ImageView = itemView.findViewById(R.id.imvBtn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemShopViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.favorite_product, parent, false)
        return ItemShopViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemShopViewHolder, position: Int) {
        val currentItem = itemList[position]

        // Bind item data to the views
        holder.pic.setImageResource(currentItem.imageResId)
        holder.titleTxt.text = currentItem.title
        holder.priceTxt.text = currentItem.price
        holder.ratingTxt.text = currentItem.rating
        holder.imvStart.setImageResource(R.drawable.star)

         holder.imvBtn.setImageResource(if (currentItem.isfavorite) R.drawable.fav_icon_filled else R.drawable.btn_3)

        // Handle item clicks to open details
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, ActivityDetails::class.java).apply {
                putExtra("title", currentItem.title)
                putExtra("price", currentItem.price)
                putExtra("rating", currentItem.rating)
                putExtra("description", currentItem.description)
                putExtra("imageResId", currentItem.imageResId)
            }
            context.startActivity(intent)
        }

         holder.imvBtn.setOnClickListener {
            currentItem.isfavorite = !currentItem.isfavorite

            if (currentItem.isfavorite) {
                holder.imvBtn.setImageResource(R.drawable.fav_icon_filled)
                if (MainActivity.favoriteItemList.none { it.id == currentItem.id }) {
                    MainActivity.favoriteItemList.add(currentItem)
                }
            } else {
                holder.imvBtn.setImageResource(R.drawable.btn_3)
                MainActivity.favoriteItemList.removeAll { it.id == currentItem.id }
            }
        }
    }

    override fun getItemCount(): Int = itemList.size
}

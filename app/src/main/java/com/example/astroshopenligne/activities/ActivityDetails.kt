package com.example.astroshopenligne.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.astroshopenligne.R

class ActivityDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val productImage: ImageView = findViewById(R.id.productImage)
        val titleTextView: TextView = findViewById(R.id.productTitle)
        val productPrice: TextView = findViewById(R.id.productPrice)
        val productRating: TextView = findViewById(R.id.productRating)
        val descriptionTxt: TextView = findViewById(R.id.descriptionTxt)
        val addToCartBtn: Button = findViewById(R.id.addToCartBtn)
        val goToCartBtn: ImageButton = findViewById(R.id.goToCartBtn)

        val title = intent.getStringExtra("title") ?: "Unknown Item"
        val price = intent.getStringExtra("price") ?: "0$"
        val rating = intent.getStringExtra("rating") ?: "N/A"
        val description = intent.getStringExtra("description") ?: "No description available"
        val imageResId = intent.getIntExtra("imageResId", R.drawable.star)

        productImage.setImageResource(imageResId)
        titleTextView.text = title
        productPrice.text = price
        productRating.text = rating
        descriptionTxt.text = description


        addToCartBtn.setOnClickListener {
            val newItem = ItemShop(
                id = System.currentTimeMillis().toInt(),
                title = title,
                price = price,
                rating = rating,
                imageResId = imageResId,
                buttonResId = R.drawable.btn_1,
                description = description,
                quantity = 1
            )
            CartManager.addToCart(newItem)
            Toast.makeText(this, "$title added to cart", Toast.LENGTH_SHORT).show()
        }

        goToCartBtn.setOnClickListener {
            Toast.makeText(this, "Going to cart", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }

        }
}

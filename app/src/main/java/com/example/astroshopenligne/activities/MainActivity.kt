package com.example.astroshopenligne.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.astroshopenligne.R

class MainActivity : AppCompatActivity() {

    companion object {
        val favoriteItemList: MutableList<ItemShop> = mutableListOf()
     }



    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemShopAdapter
    private lateinit var itemList: MutableList<ItemShop>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.viewRecommendation)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        itemList = mutableListOf()
        setDefaultProducts()

        adapter = ItemShopAdapter(itemList)
        recyclerView.adapter = adapter

        val allButton: Button = findViewById(R.id.All)
        val brandAButton: Button = findViewById(R.id.A)
        val brandBButton: Button = findViewById(R.id.B)
        val brandCButton: Button = findViewById(R.id.C)
        val favoritesButton: ImageView = findViewById(R.id.favoritesButton)
        val cartBtn: ImageView = findViewById(R.id.cartBtn)
        val buttons = listOf(allButton, brandAButton, brandBButton, brandCButton)



        cartBtn.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }

        allButton.setOnClickListener {
            updateRecyclerView(ItemData.existingItems)
            updateButtonStyles(buttons, allButton)
        }

        brandAButton.setOnClickListener {
            updateRecyclerView(ItemData.brandAItems)
            updateButtonStyles(buttons, brandAButton)
        }

        brandBButton.setOnClickListener {
            updateRecyclerView(ItemData.brandBItems)
            updateButtonStyles(buttons, brandBButton)
        }

        brandCButton.setOnClickListener {
            updateRecyclerView(ItemData.brandCItems)
            updateButtonStyles(buttons, brandCButton)
        }

        favoritesButton.setOnClickListener {
            val intent = Intent(this, FavoritesActivity::class.java)
            startActivity(intent)
        }
    }


    private fun setDefaultProducts() {
        itemList.addAll(ItemData.existingItems)
    }

    private fun updateRecyclerView(brandItems: List<ItemShop>) {
        itemList.clear()
        itemList.addAll(brandItems)
        adapter.notifyDataSetChanged()
    }

    private fun updateButtonStyles(buttons: List<Button>, selectedButton: Button) {
        val selectedBgColor = ContextCompat.getColor(this, R.color.black)
        val selectedTextColor = ContextCompat.getColor(this, R.color.white)
        val defaultBgColor = ContextCompat.getColor(this, R.color.brandsbk)
        val defaultTextColor = ContextCompat.getColor(this, R.color.black)

        buttons.forEach { button ->
            if (button == selectedButton) {
                button.setBackgroundColor(selectedBgColor)
                button.setTextColor(selectedTextColor)
            } else {
                button.setBackgroundColor(defaultBgColor)
                button.setTextColor(defaultTextColor)
            }
        }
    }
}

package com.example.astroshopenligne.activities

import com.example.astroshopenligne.R

object ItemData {
    val existingItems = listOf(
        ItemShop(1, "Item 1", "$10", "5", R.drawable.vitamina, R.drawable.btn_3, "Description of Item 1", 1, false),
        ItemShop(2, "Item 2", "$20", "4", R.drawable.vitaminb, R.drawable.btn_3, "Description of Item 2", 1, false),
        ItemShop(3, "Item 3", "$30", "3", R.drawable.vitamina1, R.drawable.btn_3, "Description of Item 3", 1, false),
        ItemShop(4, "Item 3", "$30", "3", R.drawable.vitamina1, R.drawable.btn_3, "Description of Item 3", 1, false),
        ItemShop(5, "Item 3", "$30", "3", R.drawable.vitamina1, R.drawable.btn_3, "Description of Item 3", 1, false),
        ItemShop(7, "Item 3", "$30", "3", R.drawable.vitamina1, R.drawable.btn_3, "Description of Item 3", 1, false),
        ItemShop(6, "Item 3", "$30", "3", R.drawable.vitamina1, R.drawable.btn_3, "Description of Item 3", 1, false)
    )

    val brandAItems = listOf(
        ItemShop(4, "Brand A Item 1", "$15", "5", R.drawable.vitamina1, R.drawable.btn_1, "Description of Brand A", 1, false),
        ItemShop(5, "Brand A Item 2", "$25", "4", R.drawable.vitamina, R.drawable.btn_1, "Description of Brand A", 1, false)
    )

    val brandBItems = listOf(
        ItemShop(6, "Brand B Item 1", "$10", "3", R.drawable.vitaminb, R.drawable.btn_1, "Description of Brand B", 1, false),
        ItemShop(7, "Brand B Item 2", "$20", "4", R.drawable.vitaminb, R.drawable.btn_1, "Description of Brand B", 1, false)
    )

    val brandCItems = listOf(
        ItemShop(8, "Brand C Item 1", "$30", "5", R.drawable.vitaminb, R.drawable.btn_1, "Description of Brand C", 1, false),
        ItemShop(9, "Brand C Item 2", "$40", "4", R.drawable.vitaminb, R.drawable.btn_1, "Description of Brand C", 1, false)
    )
}

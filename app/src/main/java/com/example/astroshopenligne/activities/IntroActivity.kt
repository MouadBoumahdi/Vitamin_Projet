package com.example.astroshopenligne.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.astroshopenligne.R


class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        val logoImage = findViewById<ImageView>(R.id.imageView)
        val titleText = findViewById<TextView>(R.id.textView)
        val titleText1 = findViewById<TextView>(R.id.textView1)

        val slideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down)
        val slideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up)

        logoImage.startAnimation(slideDown)
        titleText.startAnimation(slideUp)
        titleText1.startAnimation(slideUp)

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        },3000)

    }
}
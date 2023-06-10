package com.example.pamo2023

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Culinary_recipes : AppCompatActivity() {
    var back: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_culinary_recipes)
        findViewById<View>(R.id.firstRec).setOnClickListener { firstRecipe("https://recipes.net/main-dish/vegetables/asparagus-with-sherry-and-bacon-vinaigrette-recipe/#wprm-recipe-container-261") }
        findViewById<View>(R.id.secondRec).setOnClickListener { secondRecipe("https://recipes.net/main-dish/pasta/ravioli-alfredo-with-herbes-de-provence-recipe") }
        back = findViewById<View>(R.id.back) as Button
        back!!.setOnClickListener {
            val intent = Intent(this@Culinary_recipes, MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun firstRecipe(url: String?) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    fun secondRecipe(url: String?) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }
}
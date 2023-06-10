package com.example.pamo2023

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var bmi: Button? = null
    var caloriesPerDay: Button? = null
    var culinaryRecipes: Button? = null
    var quizGame: Button? = null
    var bmiChart: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bmi = findViewById<View>(R.id.bmi) as Button
        caloriesPerDay = findViewById<View>(R.id.caloriesPerDay) as Button
        culinaryRecipes = findViewById<View>(R.id.culinaryRecipes) as Button
        quizGame = findViewById<View>(R.id.quiz) as Button
        bmiChart = findViewById<View>(R.id.chartBmi) as Button
        bmi!!.setOnClickListener {
            val intent = Intent(this@MainActivity, BmiActivity::class.java)
            startActivity(intent)
        }
        bmiChart!!.setOnClickListener {
            val intent = Intent(this@MainActivity, ChartActivity::class.java)
            startActivity(intent)
        }
        caloriesPerDay!!.setOnClickListener {
            val intent = Intent(this@MainActivity, Calories_per_der::class.java)
            startActivity(intent)
        }
        culinaryRecipes!!.setOnClickListener {
            val intent = Intent(this@MainActivity, Culinary_recipes::class.java)
            startActivity(intent)
        }
        quizGame!!.setOnClickListener {
            val intent = Intent(this@MainActivity, QuizActivity::class.java)
            startActivity(intent)
        }
    }
}
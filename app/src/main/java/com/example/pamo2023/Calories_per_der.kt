package com.example.pamo2023

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Calories_per_der : AppCompatActivity() {
    private var back: Button? = null
    private var btn: Button? = null
    private var height: EditText? = null
    private var weight: EditText? = null
    private var age: EditText? = null
    private var result: TextView? = null
    private var malelayout: LinearLayout? = null
    private var femalelayout: LinearLayout? = null
    private var mimg: ImageView? = null
    private var fimg: ImageView? = null
    private var h = 0.0
    private var w = 0.0
    private var a = 0.0
    private var bmr = 0.0
    private var user = "0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calories_per_der)

        btn = findViewById(R.id.btncal)
        height = findViewById(R.id.heighttxt)
        weight = findViewById(R.id.weighttxt)
        age = findViewById(R.id.agetxt)
        result = findViewById(R.id.result)
        malelayout = findViewById(R.id.male)
        femalelayout = findViewById(R.id.female)
        mimg = findViewById(R.id.maleimg)
        fimg = findViewById(R.id.femaleimg)

        malelayout?.setOnClickListener {
            mimg?.setColorFilter(resources.getColor(R.color.white))
            fimg?.setColorFilter(resources.getColor(R.color.black))
            user = "Male"
        }

        femalelayout?.setOnClickListener {
            fimg?.setColorFilter(resources.getColor(R.color.white))
            mimg?.setColorFilter(resources.getColor(R.color.black))
            user = "Female"
        }

        btn?.setOnClickListener {
            val str1 = height?.text.toString()
            val str2 = weight?.text.toString()
            val str3 = age?.text.toString()

            if (user == "0") {
                Toast.makeText(this@Calories_per_der, "Select your gender", Toast.LENGTH_SHORT).show()
            } else if (TextUtils.isEmpty(str1)) {
                height?.setError("Select Height")
                height?.requestFocus()
                return@setOnClickListener
            } else if (TextUtils.isEmpty(str2)) {
                weight?.setError("Select Weight")
                weight?.requestFocus()
                return@setOnClickListener
            } else if (TextUtils.isEmpty(str3)) {
                age?.setError("Select Age")
                age?.requestFocus()
                return@setOnClickListener
            } else {
                calculate()
            }
        }

        back = findViewById(R.id.back) as Button
        back?.setOnClickListener {
            val intent = Intent(this@Calories_per_der, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun calculate() {
        h = height?.text.toString().toDouble()
        w = weight?.text.toString().toDouble()
        a = age?.text.toString().toDouble()

        if (user == "Male") {
            bmr = 10 * w + 6.25 * h - 5 * a + 5
            result?.text = bmr.toString()
        }

        if (user == "Female") {
            bmr = 10 * w + 6.25 * h - 5 * a + 161
            result?.text = bmr.toString()
        }
    }
}
package com.example.pamo2023

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BmiActivity : AppCompatActivity() {
    var back: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)
        val edWeg: EditText
        val edHei: EditText
        val txtRes: TextView
        val txtInter: TextView
        val btnRes: Button
        val btnReset: Button
        edWeg = findViewById<View>(R.id.edweg) as EditText
        edHei = findViewById<View>(R.id.edhei) as EditText
        txtInter = findViewById<View>(R.id.txtinter) as TextView
        txtRes = findViewById<View>(R.id.txtres) as TextView
        btnRes = findViewById<View>(R.id.btnres) as Button
        btnReset = findViewById<View>(R.id.btnreset) as Button
        back = findViewById<View>(R.id.back) as Button
        back!!.setOnClickListener {
            val intent = Intent(this@BmiActivity, MainActivity::class.java)
            startActivity(intent)
        }
        btnRes.setOnClickListener(View.OnClickListener {
            val strweg = edWeg.text.toString()
            val strhei = edHei.text.toString()
            if (strweg == "") {
                edWeg.error = "Please Enter Your Weight"
                edWeg.requestFocus()
                return@OnClickListener
            }
            if (strhei == "") {
                edHei.error = "Please Enter Your Height"
                edHei.requestFocus()
                return@OnClickListener
            }
            val weight = strweg.toFloat()
            val height = strhei.toFloat() / 100
            val bmiValue = BMICalculate(weight, height)
            txtInter.text = interpreteBMI(bmiValue)
            txtRes.text = "BMI= $bmiValue"
        })
        btnReset.setOnClickListener {
            edHei.setText("")
            edWeg.setText("")
            txtInter.text = ""
            txtRes.text = ""
        }
    }

    fun BMICalculate(weight: Float, height: Float): Float {
        return weight / (height * height)
    }

    fun interpreteBMI(bmiValue: Float): String {
        return if (bmiValue < 16) {
            "Servely Underweight"
        } else if (bmiValue < 18.5) {
            "Underweight"
        } else if (bmiValue < 21) {
            "Normal"
        } else if (bmiValue < 30) {
            "OverWeight"
        } else "Obese"
    }
}
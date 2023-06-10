package com.example.pamo2023

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet

class ChartActivity : AppCompatActivity() {
    private var bmiChart: BarChart? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chart)
        bmiChart = findViewById(R.id.bmiChart)

        // Przykładowe dane BMI
        val entries: MutableList<BarEntry> = ArrayList()
        entries.add(BarEntry(0f, 20f))
        entries.add(BarEntry(1f, 22f))
        entries.add(BarEntry(2f, 19f))
        entries.add(BarEntry(3f, 23f))
        entries.add(BarEntry(4f, 21f))
        entries.add(BarEntry(5f, 21f))
        entries.add(BarEntry(6f, 20f))
        entries.add(BarEntry(7f, 21f))
        entries.add(BarEntry(8f, 22f))
        entries.add(BarEntry(9f, 19f))
        entries.add(BarEntry(10f, 21f))
        entries.add(BarEntry(11f, 20f))
        val dataSet = BarDataSet(entries, "BMI")
        val dataSets: MutableList<IBarDataSet> = ArrayList()
        dataSets.add(dataSet)
        val barData = BarData(dataSets)
        dataSet.color = Color.BLUE // Kolor słupków

        val months = arrayOf("Jan", "Feb", "Mar", "Apr", "May", "Jun",
                "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")

        val xAxis = bmiChart?.xAxis
        xAxis?.valueFormatter = IndexAxisValueFormatter(months)
        xAxis?.textSize = 10f // Zmniejszenie rozmiaru czcionki etykiet osi X
        xAxis?.labelCount = 12 // Liczba etykiet na osi X

        val yAxisLeft = bmiChart?.axisLeft
        yAxisLeft?.axisMinimum = 0f
        yAxisLeft?.textSize = 10f // Zmniejszenie rozmiaru czcionki etykiet osi Y

        val yAxisRight = bmiChart?.axisRight
        yAxisRight?.isEnabled = false

        // Zmniejszenie szerokości słupków
        val barWidth = 0.5f // Zmniejszenie wartości, aby słupki były cieńsze
        barData.barWidth = barWidth

        // Ustawienie danych wykresu
        bmiChart?.data = barData
        bmiChart?.invalidate()
    }
}
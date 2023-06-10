package com.example.pamo2023;

import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import java.util.ArrayList;
import java.util.List;

public class ChartActivity extends AppCompatActivity {

    private BarChart bmiChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        bmiChart = findViewById(R.id.bmiChart);

        // Przykładowe dane BMI
        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0, 20f));
        entries.add(new BarEntry(1, 22f));
        entries.add(new BarEntry(2, 19f));
        entries.add(new BarEntry(3, 23f));
        entries.add(new BarEntry(4, 21f));
        entries.add(new BarEntry(5, 21f));
        entries.add(new BarEntry(6, 20f));
        entries.add(new BarEntry(7, 21f));
        entries.add(new BarEntry(8, 22f));
        entries.add(new BarEntry(9, 19f));
        entries.add(new BarEntry(10, 21f));
        entries.add(new BarEntry(11, 20f));

        BarDataSet dataSet = new BarDataSet(entries, "BMI");
        List<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(dataSet);

        BarData barData = new BarData(dataSets);

        dataSet.setColor(Color.BLUE); // Kolor słupków

        final String[] months = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        XAxis xAxis = bmiChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(months));
        xAxis.setTextSize(10f); // Zmniejszenie rozmiaru czcionki etykiet osi X
        xAxis.setLabelCount(12); // Liczba etykiet na osi X

        YAxis yAxisLeft = bmiChart.getAxisLeft();
        yAxisLeft.setAxisMinimum(0f);
        yAxisLeft.setTextSize(10f); // Zmniejszenie rozmiaru czcionki etykiet osi Y

        YAxis yAxisRight = bmiChart.getAxisRight();
        yAxisRight.setEnabled(false);

        // Zmniejszenie szerokości słupków
        float barWidth = 0.5f; // Zmniejszenie wartości, aby słupki były cieńsze
        barData.setBarWidth(barWidth);

        // Ustawienie danych wykresu
        bmiChart.setData(barData);
        bmiChart.invalidate();
    }
}
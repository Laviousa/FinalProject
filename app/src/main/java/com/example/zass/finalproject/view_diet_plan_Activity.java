package com.example.zass.finalproject;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;

public class view_diet_plan_Activity extends AppCompatActivity {

    private static String TAG="view_diet_plan_Activity";
    private float[] yData={50.0f,30.0f,20.0f};
    private String[] xData={"PROTEIN","FATS","CARBOHYDRATES"};
    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_diet_plan_);

        Log.d(TAG, "onCreate: starting to create chart");

        pieChart=(PieChart)findViewById(R.id.piechart);

        pieChart.setDescription("Nutrition Chart");
        pieChart.setDrawHoleEnabled(false);
        pieChart.setRotationEnabled(true);


        addDataSet(pieChart);

       pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
    @Override
    public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {

        Log.d(TAG, "onValueSelected: Value Select from Chart");
        Log.d(TAG, "onValueSelected: "+ e.toString());
        Log.d(TAG, "onValueSelected: "+h.toString());

    }

    @Override
    public void onNothingSelected() {

    }
});
    }

    private void addDataSet(PieChart chart) {

        Log.d(TAG, "addDataSet: started");
        ArrayList<Entry> yEntry=new ArrayList<>();
        ArrayList<String> xEntry=new ArrayList<>();

        for(int i=0;i<yData.length;i++)
        {
            yEntry.add(new Entry(yData[i],i));
        }
        for(int i=1;i<xData.length;i++)
        {
            xEntry.add(xData[i]);
        }

        PieDataSet pieDataSet=new PieDataSet(yEntry,"Nutrition Chart");
        pieDataSet.setSliceSpace(0);
        pieDataSet.setValueTextSize(12);


        ArrayList<Integer> colors=new ArrayList<>();
        colors.add(Color.GRAY);
        colors.add(Color.GREEN);
        colors.add(Color.CYAN);

        pieDataSet.setColors(colors);


        Legend legend=pieChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);

        PieData pieData = new PieData(xData,pieDataSet);

        pieChart.setData(pieData);
        pieChart.invalidate();

    }
}

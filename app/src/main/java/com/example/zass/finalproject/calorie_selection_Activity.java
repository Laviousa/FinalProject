package com.example.zass.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class calorie_selection_Activity extends AppCompatActivity {
    Spinner spinner;
    String item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_selection_);

        spinner=(Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.calorie_selection,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                item = (String)spinner.getSelectedItem();

                switch(item) {
                    case "View Calorie Chart":
                        Intent intent = new Intent(calorie_selection_Activity.this, calorie_chart_activity.class);
                        startActivity(intent);
                        break;
                    case "Evaluate Calorie Requirements":
                        Intent intent2 = new Intent(calorie_selection_Activity.this, calorie_evaluation_Activity.class);
                        startActivity(intent2);
                        break;
                    //Keep adding items.
                }

                }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}

package com.example.zass.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zass.finalproject.Model2.BMIData;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class bmiCalculation_Activity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private EditText weight;
    private EditText height;
    private Button calculateBMI;
    private TextView bmitext;

    float bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculation_);

        weight=(EditText)findViewById(R.id.weight_edit_text_2);
        height=(EditText)findViewById(R.id.height_edit_text);

        calculateBMI=(Button)findViewById(R.id.calculate_bmi_button);
      //  bmitext=(TextView)findViewById(R.id.result_bmi_text_view);


        mDatabase=(DatabaseReference) FirebaseDatabase.getInstance().getReference().child("BMI values");
        mDatabase.keepSynced(true);

        BMIData();
    }

    public void BMIData()
    {
        calculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weights=weight.getText().toString();
                String heights = height.getText().toString();
                String id=mDatabase.push().getKey();


              //  bmi=(Integer.parseInt(weights))/(Integer.parseInt(heights));

                BMIData record=new BMIData(id,weights,heights);
                mDatabase.child(String.valueOf(id)).setValue(record);

                bmi=(Float.parseFloat(weights))/((Float.parseFloat(heights))*(Float.parseFloat(heights)));
                Toast.makeText(getApplicationContext(),"This is your BMI value:" +bmi, Toast.LENGTH_SHORT).show();

            }
        });
    }
}

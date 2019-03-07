package com.example.zass.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zass.finalproject.Model3.BodyStatsData;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BodyStats_Activity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private EditText weight;
    private EditText height;
    private EditText BMI;
    private EditText waist;
    private EditText bodyfat;
    private  EditText chest;
    private EditText arm;
    private Button saveBodyStats;
    private Button updateBosyStats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_stats_);

        weight=(EditText)findViewById(R.id.weight_edit_text);
        height=(EditText)findViewById(R.id.height_edit_text);
        BMI=(EditText)findViewById(R.id.BMI_edit_text);
        waist=(EditText)findViewById(R.id.waist_edit_text);
        bodyfat=(EditText)findViewById(R.id.bodyfat_edit_text);
        chest=(EditText)findViewById(R.id.chest_edit_text);
        arm=(EditText)findViewById(R.id.arm_edit_text);
        saveBodyStats=(Button)findViewById(R.id.save_body_measurements_button);
        updateBosyStats=(Button)findViewById(R.id.update_body_measurements_button);

        mDatabase=(DatabaseReference) FirebaseDatabase.getInstance().getReference().child("Body Statistics");
        mDatabase.keepSynced(true);
        BodyStatsData();


    }

    public void BodyStatsData()
    {
        saveBodyStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weights=weight.getText().toString().trim();
                String heights=height.getText().toString().trim();
                String bmi=BMI.getText().toString().trim();
                String waists=waist.getText().toString().trim();
                String bodyfats=bodyfat.getText().toString().trim();
                String chests=chest.getText().toString().trim();
                String arms=arm.getText().toString().trim();
                String id=mDatabase.push().getKey();

                BodyStatsData record=new BodyStatsData(id,weights,heights,bmi,waists,bodyfats,chests,arms);
                mDatabase.child(String.valueOf(id)).setValue(record);
                Toast.makeText(getApplicationContext(),"Your body measurements have been saved.", Toast.LENGTH_SHORT).show();

            }
        });
    }
}

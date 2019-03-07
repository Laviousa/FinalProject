package com.example.zass.finalproject;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class Calorie_tracker_Activity extends AppCompatActivity {


    private ImageButton breakfast;
    private ImageButton lunch;
    private ImageButton snacks;
    private ImageButton dinner;
    int left_b=20;
    int top_b=80;
    int right_b=20;
    int bottom_b=10;

    int counter_b=0;

    int left_l=20;
    int top_l=250;
    int right_l=20;
    int bottom_l=10;

    int counter_l=0;


    int left_s=20;
    int top_s=430;
    int right_s=20;
    int bottom_s=10;

    int counter_s=0;


    int left_d=20;
    int top_d=620;
    int right_d=20;
    int bottom_d=10;

    int counter_d=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_tracker_);


        final ConstraintLayout constraintLayout=(ConstraintLayout)findViewById(R.id.constraint_layout);
        breakfast=(ImageButton)findViewById(R.id.imageButton_breakfast);
        lunch=(ImageButton)findViewById(R.id.imageButton_lunch);
        snacks=(ImageButton)findViewById(R.id.imageButton_snacks);
        dinner=(ImageButton)findViewById(R.id.imageButton_dinner);

        breakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               if(counter_b<2){
               EditText editText;
               editText = new EditText(Calorie_tracker_Activity.this);
               editText.setText("food");
               editText.setPadding(left_b,top_b,right_b,bottom_b);
               constraintLayout.addView(editText);
               top_b=top_b+60;
              // bottom_b=bottom_b+10;
                   counter_b++;
           }

            }
        });

        lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(counter_l<2){
                    EditText editText;
                    editText = new EditText(Calorie_tracker_Activity.this);
                    editText.setText("food");
                    editText.setPadding(left_l,top_l,right_l,bottom_l);
                    constraintLayout.addView(editText);
                    top_l=top_l+60;
                 //   bottom_l=bottom_l+10;
                    counter_l++;
                }

            }
        });

        snacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(counter_s<2){
                    EditText editText;
                    editText = new EditText(Calorie_tracker_Activity.this);
                    editText.setText("food");
                    editText.setPadding(left_s,top_s,right_s,bottom_s);
                    constraintLayout.addView(editText);
                    top_s=top_s+60;
                    //   bottom_l=bottom_l+10;
                    counter_s++;
                }

            }
        });

        dinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(counter_d<2){
                    EditText editText;
                    editText = new EditText(Calorie_tracker_Activity.this);
                    editText.setText("food");
                    editText.setPadding(left_d,top_d,right_d,bottom_d);
                    constraintLayout.addView(editText);
                    top_d=top_d+60;
                    //   bottom_l=bottom_l+10;
                    counter_d++;
                }

            }
        });
    }
}

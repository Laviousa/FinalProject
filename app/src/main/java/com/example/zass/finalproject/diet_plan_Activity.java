package com.example.zass.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class diet_plan_Activity extends AppCompatActivity {

    private Button viewDietPlan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_plan_);

        viewDietPlan=(Button)findViewById(R.id.diet_plan_button);

        viewDietPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewDietPlan();
            }
        });
    }

    public void viewDietPlan()
    {
        Intent intent=new Intent(this,view_diet_plan_Activity.class);
        startActivity(intent);

    }

}

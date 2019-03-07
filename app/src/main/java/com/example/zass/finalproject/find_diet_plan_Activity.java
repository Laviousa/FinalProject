package com.example.zass.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class find_diet_plan_Activity extends AppCompatActivity {
private Button takeTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_diet_plan_);

        takeTest=(Button)findViewById(R.id.take_quiz_button);
        takeTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuizScreen();
            }
        });

    }

    public void openQuizScreen()
    {
        Intent intent=new Intent(this,quiz_Activity.class);
        startActivity(intent);
    }
}

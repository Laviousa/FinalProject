package com.example.zass.finalproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class home_screen_activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawLayout;
    private ActionBarDrawerToggle mToggle;
    private ImageButton imgbuttonuser;
    private ImageButton imgbuttonplan;
    private ImageButton imgbuttondiet;
    private ImageButton imgbuttonexercise;
    private ImageButton imgbuttonreport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen_activity);

        drawLayout= (DrawerLayout) findViewById(R.id.drawer);
        mToggle= new ActionBarDrawerToggle(this,drawLayout,R.string.Open,R.string.Close);
        drawLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        imgbuttonuser=(ImageButton)findViewById(R.id.imageButtonUser);
        imgbuttonplan=(ImageButton)findViewById(R.id.imageButtonPlan);
        imgbuttondiet=(ImageButton)findViewById(R.id.imageButtonDiet);
        imgbuttonexercise=(ImageButton)findViewById(R.id.imageButtonExercise);
        imgbuttonreport=(ImageButton)findViewById(R.id.imageButtonReport);


        imgbuttonplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openFindDietPlan();

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mToggle.onOptionsItemSelected(item))
        {

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();

        switch (id)
        {
            case R.id.bS:
                Intent bs=new Intent(home_screen_activity.this,BodyStats_Activity.class);
                startActivity(bs);
                break;

            case R.id.bC:
                Intent bc=new Intent(home_screen_activity.this,bmiCalculation_Activity.class);
                startActivity(bc);
                break;

            case R.id.cT:
                Intent ct=new Intent(home_screen_activity.this, Calorie_tracker_Activity.class);
                startActivity(ct);
                break;


            case R.id.lG:
                Intent lg=new Intent(home_screen_activity.this, home_screen_activity.class);
                startActivity(lg);
                break;
        }



        return false;
    }

    public void openFindDietPlan()
    {
        Intent intent=new Intent(this,find_diet_plan_Activity.class);
        startActivity(intent);
    }

}

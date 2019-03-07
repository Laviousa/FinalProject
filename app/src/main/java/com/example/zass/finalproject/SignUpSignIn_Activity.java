package com.example.zass.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUpSignIn_Activity extends AppCompatActivity {


    private Button signUp;
    private Button signIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_sign_in_);

        signUp=(Button)findViewById(R.id.button_sign_up);
        signIn=(Button)findViewById(R.id.button_sign_in);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUpActivity();
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignInActivity();
            }
        });
    }

    public void openSignUpActivity()
    {
        Intent intent1=new Intent(this,SingUp_Activity.class);
        startActivity(intent1);
    }

    public void openSignInActivity()
    {
        Intent intent=new Intent(this,SignIn_Activity.class);
        startActivity(intent);
    }
}

package com.example.zass.finalproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zass.finalproject.Model.SignUpData;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SingUp_Activity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private EditText user_name;
    private EditText user_age;
    private EditText user_email;
    private EditText user_password;
    private Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up_);

        mAuth=FirebaseAuth.getInstance();

        signup=(Button)findViewById(R.id.email_sign_up_button);
        user_name=(EditText)findViewById(R.id.user_name);
        user_age=(EditText)findViewById(R.id.user_age);
        user_email=(EditText)findViewById(R.id.user_email);
        user_password=(EditText)findViewById(R.id.user_password);


        mDatabase=(DatabaseReference) FirebaseDatabase.getInstance().getReference().child("Registered users");
        mDatabase.keepSynced(true);
        SignUpData();
    }


    public void SignUpData()
    {
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=user_name.getText().toString().trim();
                String age=user_age.getText().toString().trim();
                String email=user_email.getText().toString().trim();
                String password=user_password.getText().toString().trim();
                String id=mDatabase.push().getKey();

                SignUpData record=new SignUpData(id,name,age,email,password);
                mDatabase.child(String.valueOf(id)).setValue(record);

                if(TextUtils.isEmpty(email)){
                    user_email.setError("Email Required...");
                }
                if(TextUtils.isEmpty(password)){
                    user_password.setError("Password Required...");
                }
                if (TextUtils.isEmpty(name))

                {
                    user_name.setError("Name Required...");
                }
                if (TextUtils.isEmpty(age))
                {
                    user_age.setError("Age Required...");
                }
                if ((TextUtils.isEmpty(email)==false)&&(TextUtils.isEmpty(password)==false)&&(TextUtils.isEmpty((name))==false)&&(TextUtils.isEmpty(age)==false))
                {

                    mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(getApplicationContext(),"You are registered", Toast.LENGTH_SHORT).show();
                                openHomeScreen();



                        }


                    });

                }



            }
        });
    }
    public void openHomeScreen()
    {
        Intent intent=new Intent(this,home_screen_activity.class);
        startActivity(intent);
    }

}

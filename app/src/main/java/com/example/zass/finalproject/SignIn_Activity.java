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

import com.example.zass.finalproject.Model4.SignInData;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignIn_Activity extends AppCompatActivity {

    private DatabaseReference mDatabase;
private FirebaseAuth mAuth;
    private EditText email;
    private EditText password;
    private Button signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_);


        email=(EditText)findViewById(R.id.user_email);
        password=(EditText)findViewById(R.id.user_password);

        signIn=(Button)findViewById(R.id.email_sign_in_button);

        mDatabase=(DatabaseReference) FirebaseDatabase.getInstance().getReference().child("Logged In Users");
        mDatabase.keepSynced(true);

        SignInData();
    }

    public void SignInData()
    {
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emails=email.getText().toString().trim();
                String passwords=password.getText().toString().trim();

                String id=mDatabase.push().getKey();
              if ((TextUtils.isEmpty(emails)==false)&&(TextUtils.isEmpty(passwords)==false))
                 {
                     mAuth.createUserWithEmailAndPassword(emails,passwords).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                         @Override
                         public void onComplete(@NonNull Task<AuthResult> task) {

                             if (task.isSuccessful())
                             {
                                 openHomeScreen();
                                 Toast.makeText(getApplicationContext(),"You're signed in.", Toast.LENGTH_SHORT).show();

                             }
                             else
                             {
                                 Toast.makeText(getApplicationContext(),"Problem in Auth",Toast.LENGTH_SHORT).show();

                             }

                         }
                     });
                 }
                if(TextUtils.isEmpty(emails)){
                    email.setError("Email Required...");
                }
                if(TextUtils.isEmpty(passwords)){
                    password.setError("Password Required...");
                }

                SignInData record=new SignInData(id, emails,passwords);
                mDatabase.child(String.valueOf(id)).setValue(record);



            }
        });
    }

    public void openHomeScreen()
    {
        Intent intent=new Intent(this,home_screen_activity.class);
        startActivity(intent);
    }
}

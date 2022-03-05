package com.example.mpishi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

//sign In

public class SigninActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        TextView username =(TextView) findViewById(R.id.username);
        TextView password =(TextView) findViewById(R.id.password);

        MaterialButton loginbtn = (MaterialButton ) findViewById(R.id.loginbtn);

        //admin and admin
        loginbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                    //correct
                    Toast.makeText(SigninActivity.this,"LOGIN SUCCESSFUL",Toast.LENGTH_LONG).show();
                }else{
                    //incorrect
                    Toast.makeText(SigninActivity.this,"LOGIN FAILED !!!",Toast.LENGTH_LONG).show();
                }
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                    //correct
                    startActivity(new Intent(SigninActivity.this,LandingActivity.class));
                }else{
                    //incorrect
                    Toast.makeText(SigninActivity.this,"LOGIN FAILED !!!",Toast.LENGTH_LONG).show();
                }
            }
        });

        textView=(TextView) findViewById(R.id.sighnup);
        textView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(SigninActivity.this,SignupActivity.class);
                startActivity(intent);

                Toast.makeText(SigninActivity.this, "start today", Toast.LENGTH_LONG).show();
            }
        });


    }
}

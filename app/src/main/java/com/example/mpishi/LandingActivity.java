package com.example.mpishi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mpishi.User.SigninActivity;
import com.google.android.material.button.MaterialButton;

public class LandingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        MaterialButton loginbtn1 = (MaterialButton) findViewById(R.id.loginbtn1);

        loginbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(new Intent(LandingActivity.this, SigninActivity.class));
            }
        });
    }
}

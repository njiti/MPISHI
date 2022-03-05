package com.example.mpishi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class SignupActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        MaterialButton loginbtn2 = (MaterialButton) findViewById(R.id.loginbtn2);

        loginbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(new Intent(SignupActivity.this,ShortActivity.class));
            }
        });
    }
}

//textView=(TextView) findViewById(R.id.sighnup);
//textView.setOnClickListener(new View.OnClickListener(){
//@Override
//public void onClick(View v){
//Intent intent=new Intent(SignupActivity.this,MainActivity.class);
//startActivity(intent);

//Toast.makeText(SignupActivity.this, "already started", Toast.LENGTH_LONG).show();
//}
//});

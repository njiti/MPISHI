package com.example.mpishi.User;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mpishi.Home.HomeActivity;
import com.example.mpishi.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

//sign In

public class SigninActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

       // private FirebaseAuth mAuth;
// ...
// Initialize Firebase Auth
        //mAuth = FirebaseAuth.getInstance();

        TextView username =(TextView) findViewById(R.id.username);
        TextView password =(TextView) findViewById(R.id.password);


        /*@Override
        public void onStart() {
            super.onStart();
            /// Check if user is signed in (non-null) and update UI accordingly.
            FirebaseUser currentUser = mAuth.getCurrentUser();
            updateUI(currentUser);
        }*/
        MaterialButton loginbtn = (MaterialButton ) findViewById(R.id.loginbtn);

       /* mAuth.signInWithCustomToken(mCustomToken)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCustomToken:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCustomToken:failure", task.getException());
                            Toast.makeText(CustomAuthActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });*/

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
                    startActivity(new Intent(SigninActivity.this, HomeActivity.class));
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
                Intent intent=new Intent(SigninActivity.this, SignupActivity.class);
                startActivity(intent);

                Toast.makeText(SigninActivity.this, "start today", Toast.LENGTH_LONG).show();
            }
        });


    }
}

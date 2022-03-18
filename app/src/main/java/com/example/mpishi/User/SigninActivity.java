package com.example.mpishi.User;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mpishi.Home.HomeActivity;
import com.example.mpishi.R;
import com.example.mpishi.Tutorials.ShortActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

//sign In

public class SigninActivity extends AppCompatActivity {

    TextView textView;
    EditText inusername,inpassword,inemail;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        inemail=findViewById(R.id.inemail);
        inpassword=findViewById(R.id.inpassword);

        progressDialog=new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        MaterialButton loginbtn = (MaterialButton ) findViewById(R.id.loginbtn);
        mUser=mAuth.getCurrentUser();

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                performLogin();

                textView=(TextView) findViewById(R.id.sighnup);
                textView.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent intent=new Intent(SigninActivity.this, SignupActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });
    }
    private void performLogin() {
        String email = inemail.getText().toString();
        String password = inpassword.getText().toString();

        if (!email.matches(emailPattern)) {
            inemail.setError("Enter Correct Email");
        } else if (password.isEmpty() || inpassword.length() < 6) {
            inpassword.setError("Enter Proper Password, not less than 6 characters");
        }else {
            progressDialog.setMessage("Please wait While SignIn...");
            progressDialog.setTitle("Sign In");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(SigninActivity.this, "LogIn Successful", Toast.LENGTH_SHORT).show();
                    }else {
                        progressDialog.dismiss();
                        Toast.makeText(SigninActivity.this, ""+task.getException(), Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
    private void sendUserToNextActivity(){
        Intent intent=new Intent(SigninActivity.this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}

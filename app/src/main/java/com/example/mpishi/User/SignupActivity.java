package com.example.mpishi.User;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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

public class SignupActivity extends AppCompatActivity {

    TextView textView;
    EditText inputEmail,inputusername,inputpassword,inputpassword2;

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        inputEmail=findViewById(R.id.inputEmail);
        inputpassword=findViewById(R.id.inputpassword);
        inputpassword2=findViewById(R.id.inputpassword2);
        MaterialButton loginbtn2 = (MaterialButton) findViewById(R.id.loginbtn2);
        progressDialog= new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();

        loginbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                perforAuth();
            }
        });
    }
    private void perforAuth(){
        String email= inputEmail.getText().toString();
        String password= inputpassword.getText().toString();
        String password2= inputpassword2.getText().toString();

        if (!email.matches(emailPattern)) {
            inputEmail.setError("Enter Correct Email");
        }else if(password.isEmpty() || inputpassword.length()<6){
            inputpassword.setError("Enter Proper Password, not less than 6 characters");
        }else if(!password2.equals(inputpassword2)) {
            inputpassword2.setError("Passwords don't match");
        }else{
            progressDialog.setMessage("Please wait While Registration...");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(SignupActivity.this, "Registration Success", Toast.LENGTH_LONG).show();
                    }else {
                        progressDialog.dismiss();
                        Toast.makeText(SignupActivity.this, ""+task.getException(), Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
    private void sendUserToNextActivity(){
        Intent intent=new Intent(SignupActivity.this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
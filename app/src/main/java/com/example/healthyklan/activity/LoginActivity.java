package com.example.healthyklan.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthyklan.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private TextView tvLogin;
    private EditText etEmail;
    private EditText etPassword;
    private TextView tvGoogleLogin;
    private TextView tvFacebookLogin;
    private TextView tvNewUser;

    String email;
    String password;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvLogin = findViewById(R.id.tv_login);
        etEmail = findViewById(R.id.tietEmialLogin);
        etPassword = findViewById(R.id.tietPassLogin);
        tvGoogleLogin = findViewById(R.id.tvGoogleLogin);
        tvFacebookLogin = findViewById(R.id.tvFacebookLogin);
        tvNewUser = findViewById(R.id.tvNewUser);

        mAuth = FirebaseAuth.getInstance();

        tvNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email = etEmail.getText().toString();
                password = etPassword.getText().toString();

                if(email.isEmpty()){
                    etEmail.setError("Email is required!");
                    etEmail.requestFocus();
                    return;
                }
//                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
//                    etEmail.setError("Please enter valid email!");
//                    etEmail.requestFocus();
//                    return;
//                }
                if(password.isEmpty()){
                    etPassword.setError("Password id required!");
                    etPassword.requestFocus();
                    return;
                }

                if(password.length()<6){
                    etPassword.setError("Min 6 characters");
                    etPassword.requestFocus();
                    return;
                }

                Toast.makeText(LoginActivity.this, "Email : "+email+" pass : "+password, Toast.LENGTH_SHORT).show();
                mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener( (OnCompleteListener<AuthResult>) task -> {

                    if(task.isSuccessful()){
                        Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                        startActivity(intent);
                        finishOnSignUp();
                        finish();
                    }else{
                        Toast.makeText(LoginActivity.this, "Login not successfull please try again", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });


    }

    private void finishOnSignUp() {
        SharedPreferences sp  = getSharedPreferences("onSignup", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("SIGNUP",true);
        editor.apply();
        editor.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
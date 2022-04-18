package com.example.healthyklan.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.healthyklan.R;
import com.example.healthyklan.modal.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    TextView tvSignUp;
    TextView tvAlreadyUser;
    EditText etNAmeSignup;
    EditText etEmailSignup;
    EditText etPassSignup;
    EditText etConPassSignup;
    TextView tvGoogleSignUp;
    TextView tvFaceBookSignUp;

    private FirebaseAuth mAuth;

    String name = "";
    String email = "";
    String pass = "";
    String conPass = "";

    int good  = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


            setContentView(R.layout.activity_sign_up);

        tvSignUp = findViewById(R.id.tvSignup);
        tvAlreadyUser = findViewById(R.id.tvalreadyAUserInSignUp);
        etNAmeSignup = findViewById(R.id.tietNameSignup);
        etEmailSignup = findViewById(R.id.tietEmailSignup);
        etPassSignup = findViewById(R.id.tietPassSignup);
        etConPassSignup = findViewById(R.id.tietConfPassSignup);
        tvGoogleSignUp = findViewById(R.id.tvGoogleSignUp);
        tvFaceBookSignUp = findViewById(R.id.tvFacebookSignup);

        mAuth = FirebaseAuth.getInstance();

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isConnected()){
                    Toast.makeText(SignUpActivity.this, "Connected", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SignUpActivity.this, "Not COnnected", Toast.LENGTH_SHORT).show();
                }

                name = etNAmeSignup.getText().toString();
                email = etEmailSignup.getText().toString();
                pass = etPassSignup.getText().toString();
                conPass = etConPassSignup.getText().toString();

                good=0;
                if (name.isEmpty()) {
                    good--;
                    etNAmeSignup.setError("Enter valid name");
                } else {
                    good++;
                }
                if (email.isEmpty()) {
                    good--;
                    etEmailSignup.setError("Enter valid email");
                } else {
                    good++;
                }
                if (pass.isEmpty()) {
                    good--;
                    etPassSignup.setError("Enter valid password");
                } else {
                    good++;
                }
                if (!conPass.equals( pass)) {
                    good--;
                    etConPassSignup.setError("Password do not match!");
                } else {
                    good++;
                }

                if(pass.length()<6){
                    etPassSignup.setError("Enter min 6 character!");
                    good--;
                }else {
                    good++;
                }

                if(good == 5) {
                getSignUp();
                }
            }
        });


        tvAlreadyUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void getSignUp() {
        //Toast.makeText(SignUpActivity.this, name+": name "+email+": email "+pass+" : pass" , Toast.LENGTH_SHORT).show();
        mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(SignUpActivity.this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    User user = new  User(name, email);
                    FirebaseDatabase.getInstance()
                            .getReference("Users")
                            .child(FirebaseAuth.getInstance()
                                    .getCurrentUser().getUid())
                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(SignUpActivity.this, "User has been registered!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SignUpActivity.this,HomeActivity.class);
                                startActivity(intent);
                                finishOnSignUp();
                                finish();
                            }else{
                                Toast.makeText(SignUpActivity.this, "Failed to register. Try Again!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }else{
                    Toast.makeText(SignUpActivity.this, "Not entering into databse if", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    boolean isConnected(){
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netinfo = manager.getActiveNetworkInfo();

        if(netinfo!=null){
            if(netinfo.isConnected())
                return true;
            else{
                return false;
            }
        }else return false;
    }

    private void finishOnSignUp(){
        SharedPreferences sp  = getSharedPreferences("onSignup", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("SIGNUP",true);
        editor.apply();
        editor.commit();
    }

    private boolean OnSignUp(){
        SharedPreferences sptwo = getSharedPreferences("onSignup", Context.MODE_PRIVATE);
        return sptwo.getBoolean("SIGNUP",false);
    }

}
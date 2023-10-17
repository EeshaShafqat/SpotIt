package com.example.spotit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    EditText email, password;
    Button login;

    TextView signup;
    TextView forgot;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FireAuthSingleton.getInstance();

        signup = findViewById(R.id.signup);
        email = findViewById(R.id.enter_email);
        password = findViewById(R.id.enter_password);
        login = findViewById(R.id.LoginBtn);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent);

            }
        });

        forgot = findViewById(R.id.forgot_password);

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Login.this, ForgotPassword.class);
                startActivity(intent);

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String em,pass;
                em = String.valueOf(email.getText());
                pass = String.valueOf(password.getText());

                if(TextUtils.isEmpty(em)){
                    Toast.makeText(Login.this, "Enter email ", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(pass)){
                    Toast.makeText(Login.this, "Enter password ", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.signInWithEmailAndPassword(em, pass)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    FirebaseUser user = mAuth.getCurrentUser();

                                    Toast.makeText(Login.this, "Authentication successful.",
                                            Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(Login.this, Dashboard.class);
                                    startActivity(intent);
                                    finish();


                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(Login.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });

            }
        });




    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser != null) {

            Toast.makeText(Login.this, currentUser.getUid() + " ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Login.this, Dashboard.class);
            intent.putExtra("FRAGMENT_TO_LOAD", "home");
            startActivity(intent);
            finish();
        }
    }


}
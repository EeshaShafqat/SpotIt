package com.example.spotit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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

public class SignUp extends AppCompatActivity {

    EditText email, password;
    Button signup;
    TextView login;

   FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth  = FireAuthSingleton.getInstance();

        email = findViewById(R.id.enter_email);
        password = findViewById(R.id.enter_password);
        signup = findViewById(R.id.sign_up_button);

        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(SignUp.this, Login.class);
                startActivity(intent);

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String em,pass;
                em = email.getText().toString();
                pass = password.getText().toString();

                if(TextUtils.isEmpty(em)){
                    Toast.makeText(SignUp.this, "Enter email ", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(pass)){
                    Toast.makeText(SignUp.this, "Enter password ", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(em, pass)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    //FirebaseUser user = mAuth.getCurrentUser();

                                    Toast.makeText(SignUp.this, "Authentication successful.",
                                            Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(SignUp.this, Dashboard.class);
                                    startActivity(intent);
                                    finish();

                                } else {
                                    // If sign in fails, display a message to the user.

                                    Toast.makeText(SignUp.this, "Authentication failed.",
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

            Toast.makeText(SignUp.this, currentUser.getUid() + " ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(SignUp.this, Dashboard.class);
            intent.putExtra("FRAGMENT_TO_LOAD", "profile");
            startActivity(intent);
            finish();
        }
    }


}
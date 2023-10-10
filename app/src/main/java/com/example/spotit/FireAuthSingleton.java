package com.example.spotit;


import com.google.firebase.auth.FirebaseAuth;

public class FireAuthSingleton {
    private static FirebaseAuth mAuth;

    private FireAuthSingleton() { }

    public static synchronized FirebaseAuth getInstance() {
        if (mAuth == null) {
            mAuth = FirebaseAuth.getInstance();
        }
        return mAuth;
    }
}

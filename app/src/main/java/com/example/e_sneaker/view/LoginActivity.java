package com.example.e_sneaker.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.e_sneaker.viewmodel.LoginViewModel;
import com.example.e_sneaker.R;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private static final int RC_SIGN_IN = 42;
    private LoginViewModel loginViewModel;

    EditText inputEmail;
    EditText inputPassword;
    Button loginButton;
    Button registerButton;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        firebaseAuth = FirebaseAuth.getInstance();

        //inputEmail = findViewById(R.id.inputEmail);
        //inputPassword = findViewById(R.id.inputPassword);
        loginButton = this.findViewById(R.id.loginButton);
        //registerButton = this.findViewById(R.id.registerButton);

        /*registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getEmail = inputEmail.getText().toString();
                String getPassword = inputPassword.getText().toString();
                firebaseAuth.createUserWithEmailAndPassword(getEmail, getPassword)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(LoginActivity.this, "User Account Created", Toast.LENGTH_SHORT).show();
                        goToMainActivity();
                    }
                })
                        .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(LoginActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getEmail = inputEmail.getText().toString();
                String getPassword = inputPassword.getText().toString();

                firebaseAuth.signInWithEmailAndPassword(getEmail, getPassword)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(LoginActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                        goToMainActivity();
                    }
                })
                        .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(LoginActivity.this, "Login Failed :(", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });*/

        checkIfSignedIn();
        setContentView(R.layout.activity_login);
    }

    private void checkIfSignedIn() {
        loginViewModel.getCurrentUser().observe(this, user -> {
            if (user != null)
                goToMainActivity();
        });
    }

    private void goToMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    public void signIn(View v){
        try {
            List<AuthUI.IdpConfig> providers = Arrays.asList(
                    new AuthUI.IdpConfig.EmailBuilder().build(),
                    new AuthUI.IdpConfig.GoogleBuilder().build());

            Intent loginIntent = AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setAvailableProviders(providers)
                    .build();

            startActivityForResult(loginIntent, RC_SIGN_IN);
        } catch (Exception e){
            Log.i("Log in", "Email or password are empty");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN){
            handleSignInRequest(resultCode);
        }
    }

    private void handleSignInRequest(int resultCode){
        if (resultCode == RESULT_OK){
            goToMainActivity();
        } else Toast.makeText(this, "SIGN IN CANCELLED", Toast.LENGTH_SHORT).show();
    }

    public void login(View view) {
        //Should I checkIfSignedIn first??
        signIn(view);
    }

    public void register(View view) {
        String getEmail = inputEmail.getText().toString();
        String getPassword = inputPassword.getText().toString();
        firebaseAuth.createUserWithEmailAndPassword(getEmail, getPassword)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(LoginActivity.this, "User Account Created", Toast.LENGTH_SHORT).show();
                        goToMainActivity();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(LoginActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
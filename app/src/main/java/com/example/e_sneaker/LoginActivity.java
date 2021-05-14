package com.example.e_sneaker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;

import java.util.Arrays;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private static final int RC_SIGN_IN = 42;
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
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

    public void register(View view) { //not gonna implement register for now
        //startActivity(new Intent(Register.this, MainActivity.class));
    }
}
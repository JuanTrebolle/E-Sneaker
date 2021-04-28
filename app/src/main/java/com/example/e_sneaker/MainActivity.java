package com.example.e_sneaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*I'll use SplashTheme in the moment that the app is loading, and the default theme(ESneaker)
        * when it's already loaded*/
        setTheme(R.style.Theme_ESneaker);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
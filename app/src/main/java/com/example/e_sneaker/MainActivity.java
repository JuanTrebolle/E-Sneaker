package com.example.e_sneaker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

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

        Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar); // With this the app crashes
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.search){
            //TODO: call viewModel to search specific shoe
            Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
        } if (itemId == R.id.shoppingCart){
            //TODO: call viewModel to go to shopping cart activity
            //TODO: add a ancestral/up navigation button in shopping cart activity
            //TODO: add ancestral button in shopping cart activity
            /*
             * For adding ancestral button:
             *   1. In the activity xml file, add android:parentActivityName=".MainActivity"
             *   2. Add in the java file: getSupportActionBar().setDisplayHomeAsUpEnabled(true)
             * */
            Toast.makeText(this, "Shopping Cart", Toast.LENGTH_SHORT).show();
        }else if (itemId == R.id.profile){
            //TODO: call viewModel to enter profile settings
            //TODO: when in the profile/settings activity, add a ancestral/up navigation button
            Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.settings){
            //TODO: call viewModel to enter settings
            //TODO: when in the settings activity, add a ancestral/up navigation button
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
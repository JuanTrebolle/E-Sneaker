package com.example.e_sneaker.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.e_sneaker.R;
import com.example.e_sneaker.repository.SneakerRepository;
import com.example.e_sneaker.view.fragment.Cart_Fragment;
import com.example.e_sneaker.view.fragment.FireSneakers_Fragment;
import com.example.e_sneaker.view.fragment.Profile_Fragment;
import com.example.e_sneaker.view.fragment.Store_Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private SneakerRepository sneakerRepository;
    private static final String TAG = "MainActivity";
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //SPLASH-THEME
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*I'll use SplashTheme in the moment that the app is loading, and the default theme(ESneaker)
         * when it's already loaded*/
        setTheme(R.style.Theme_ESneaker);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Set the initial fragment to Store-fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayoutFragment, new Cart_Fragment());
        transaction.commit();

        //Bottom Navigation View
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.nav_home); //the first item selected by default

        sneakerRepository = SneakerRepository.getInstance();
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
            //sneakerRepository.requestSneakersByBrand(String.valueOf(item.getTitle()));
            sneakerRepository.requestSneakersByBrand(String.valueOf("Jordan"));
            Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.nav_home){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutFragment, new Store_Fragment()).commit();
            return true;
        } else if (item.getItemId() == R.id.nav_fire){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutFragment, new FireSneakers_Fragment()).commit();
            return true;
        } else if (item.getItemId() == R.id.nav_cart){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutFragment, new Cart_Fragment()).commit();
            return true;
        } else if (item.getItemId() == R.id.nav_profile){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutFragment, new Profile_Fragment()).commit();
            return true;
        }

        Log.i(TAG, "onNavigationItemSelected: " + item.toString());
        return false; // If true means the item selected has been handled
    }
}
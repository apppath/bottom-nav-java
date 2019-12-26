package com.basic.programming.bottomnavigationdemo;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.basic.programming.bottomnavigationdemo.fragments.MessageFragment;
import com.basic.programming.bottomnavigationdemo.fragments.HomeFragment;
import com.basic.programming.bottomnavigationdemo.fragments.PlayerFragment;
import com.basic.programming.bottomnavigationdemo.fragments.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new HomeFragment());

        bottomNav = findViewById(R.id.navigation);
        bottomNav.setOnNavigationItemSelectedListener(this);

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.homeFragment:
                fragment = new HomeFragment();
                break;

            case R.id.favsFragment:
                fragment = new MessageFragment();
                break;

            case R.id.settingsFragment:
                fragment = new SettingsFragment();
                break;

            case R.id.playerFragment:
                fragment = new PlayerFragment();
                break;

        }

        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {

        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;

    }
}

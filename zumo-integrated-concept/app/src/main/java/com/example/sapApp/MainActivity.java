package com.example.sapApp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    StartUpFragment mStart;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate((savedInstanceState));
        setContentView(R.layout.main_activity);

        mStart= new StartUpFragment();

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.container, mStart)
                .commit();


    }



}

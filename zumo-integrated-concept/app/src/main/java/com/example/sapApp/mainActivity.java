package com.example.sapApp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class mainActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    startUpFragment mStart;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate((savedInstanceState));
        setContentView(R.layout.main_activity);

        mStart= new startUpFragment();

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.container, mStart)
                .commit();


    }



}

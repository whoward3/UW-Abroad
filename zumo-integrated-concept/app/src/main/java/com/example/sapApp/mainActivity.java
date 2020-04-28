package com.example.sapApp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

/*
    This is the Main Activity which is called on startup.
    This then sets up the chain of fragments.
        -Alice Blair April 28, 2020
 */

public class mainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    startUpFragment mStart;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        //AB: Set up the view
        super.onCreate((savedInstanceState));
        setContentView(R.layout.main_activity);

        //AB: Create the First fragment and run it
        mStart= new startUpFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.container, mStart)
                .commit();
    }
}

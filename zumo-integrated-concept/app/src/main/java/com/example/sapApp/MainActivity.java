package com.example.sapApp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    SchoolActivity mSchoolActivity;
    StartUpFragment mStart;
    OutgoingHomePage mOut;
    IncomingHomePage mIn;
    LaramieFacts mLf;
    laramieMapFragment mLMF;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate((savedInstanceState));
        setContentView(R.layout.main_activity);


        mSchoolActivity = new SchoolActivity();
        mStart= new StartUpFragment();
        mOut= new OutgoingHomePage();
        mIn = new IncomingHomePage();
        mLf = new LaramieFacts();
        mLMF = new laramieMapFragment();


        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.container, mStart)
                .commit();


    }



}

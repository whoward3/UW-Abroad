package com.example.sapApp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    ToDoActivity mToDoActivity;
    StartUpFragment mStart;
    OutgoingHomePage mOut;
    IncomingHomePage mIn;
    LaramieFacts mLf;
    laramieMapFragment mLMF;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate((savedInstanceState));
        setContentView(R.layout.main_activity);


        mToDoActivity = new ToDoActivity();
        mStart= new StartUpFragment();
        mOut= new OutgoingHomePage();
        mIn = new IncomingHomePage();
        mLf = new LaramieFacts();
        mLMF = new laramieMapFragment();


        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.container, mIn)
                .commit();


    }

}

package com.example.sapApp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    ToDoActivity mToDoActivity;
    StartUpFragment mStart;
    OutgoingHomePage mOut;
    IncomingHomePage mIn;
    LaramieFacts mLf;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate((savedInstanceState));
        setContentView(R.layout.main_activity);


        mToDoActivity = new ToDoActivity();
        mStart= new StartUpFragment();
        mOut= new OutgoingHomePage();
        mIn = new IncomingHomePage();
        mLf = new LaramieFacts();


        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.container, mLf)
                .commit();


    }

}

//StartUpPage.java
package edu.uwyo.uwyoabroadappfrontend;
/*
Created By S Blair
Nov 12 2019
Created Startup page and the respective XML file
Still need to add the picture that was on the wireframe
 */

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class StartUpPage extends Fragment {

    Button incoming, outgoing;


    public StartUpPage() {}// SB: Required empty public constructor




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //SB: Set Up the View and buttons
        View view = inflater.inflate(R.layout.fragment_start_up_page, container, false);
        incoming = view.findViewById(R.id.incomingButton);
        outgoing = view.findViewById(R.id.outGoingButton);


        incoming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SB: Set Up Connection Here
            }
        });

        outgoing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SB: Set Up Connection Here
            }
        });


        // Inflate the layout for this fragment
        return view;
    }

}

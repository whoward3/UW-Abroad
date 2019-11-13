//IncomingHomePage.java
package edu.uwyo.uwyoabroadappfrontend;
/*
Created By S Blair
Nov 12 2019
Created Incoming Home page and the respective XML file
This shows after incoming is clicked on the home page
Still need to add the picture that was on the wireframe
 */


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class IncomingHomePage extends Fragment {


    Button about, laramie, degree, nondegree;

    public IncomingHomePage() {} // SB:Required empty public constructor




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        //SB: Set Up the View and buttons
        View view = inflater.inflate(R.layout.fragment_start_up_page, container, false);
        about = view.findViewById(R.id.aboutButton);
        laramie = view.findViewById(R.id.laramieButton);
        degree = view.findViewById(R.id.degreeButton);
        nondegree = view.findViewById(R.id.nonDegreeButton);


        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SB: Set Up Connection Here to a page that auto-fills using ethan's college page
            }
        });

        laramie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SB: Set Up Connection Here to the laramie map page
            }
        });
        degree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SB: Directed to a blank page on the wireframe so oyu can ignore this one for now
            }
        });

        nondegree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SB: Directed to a blank page on the wireframe so oyu can ignore this one for now
                }
        });


        return view;
    }

}

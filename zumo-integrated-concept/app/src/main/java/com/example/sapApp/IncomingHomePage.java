package com.example.sapApp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class IncomingHomePage extends Fragment {

    Button about, laramie, degree, laramieMap;

    public IncomingHomePage() {} // SB:Required empty public constructor




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        //SB: Set Up the View and buttons
        View view = inflater.inflate(R.layout.fragment_incoming_home_page, container, false);
        about = view.findViewById(R.id.aboutButton);
        laramie = view.findViewById(R.id.laramieButton);
        degree = view.findViewById(R.id.degreeButton);
        laramieMap = view.findViewById(R.id.campusMap);


        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SB: Set Up Connection Here to a page that auto-fills using ethan's college page
            }
        });

        laramie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SB: Set Up Connection Here to the laramie facts page
            }
        });
        degree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SB: Directed to a blank page on the wireframe so oyu can ignore this one for now
            }
        });

        laramieMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SB: Directed to a blank page on the wireframe so oyu can ignore this one for now
            }
        });


        return view;
    }

}

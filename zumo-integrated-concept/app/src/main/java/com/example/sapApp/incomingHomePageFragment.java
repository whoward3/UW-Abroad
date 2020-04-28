package com.example.sapApp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/*
    This class is used to view the incoming homepage.
    It has a small welcome message and 4 buttons.
    Those buttons are:
            - An About UW page
            - A Laramie Facts Page
            - An Areas of Study Page
            - A map of the UW Laramie Campus
        -Alice Blair April 28, 2020
 */

public class incomingHomePageFragment extends Fragment {

    Button aboutButton, laramieFactsButton, areasOfStudyButton, laramieMapButton;

    public incomingHomePageFragment() {
    } //AB: Required empty public constructor

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //AB: Set Up the View and buttons
        View view = inflater.inflate(R.layout.fragment_incoming_home_page, container, false);
        aboutButton = view.findViewById(R.id.aboutButton);
        laramieFactsButton = view.findViewById(R.id.laramieButton);
        areasOfStudyButton = view.findViewById(R.id.degreeButton);
        laramieMapButton = view.findViewById(R.id.campusMap);

        /*
            Below are the on click listeners for all of the buttons.
            If we could condense and reuse the code that would be optimal,
            but it broke when we tried to condense it.
            Thus, for right now it is a big paragraph for each one.
                - Alice Blair April 28, 2020
         */

        //AB: This creates and opens a xml resource fragment and passes a 1.
        //AB: 1 = the About UW layout switch case.
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xml_resource_fragment nextFrag= new xml_resource_fragment(1);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, nextFrag, "UW Facts Fragment");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        //AB: This creates and opens a xml resource fragment and passes nothing.
        //AB: Nothing = the Laramie Facts layout switch case, which is the default.
        laramieFactsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xml_resource_fragment nextFrag= new xml_resource_fragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, nextFrag, "Laramie Fragment");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        //AB: This creates and a major fragment and displays the area of studies.
        areasOfStudyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                majorFragment nextFrag= new majorFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, nextFrag, "Degree Fragment");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        //AB: This creates and opens a PDF viewer fragment and passes a 1.
        //AB: 1 = the Laramie Campus Map switch case.
        laramieMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pdfViewerFragment nextFrag = new pdfViewerFragment(1);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container,nextFrag, "Laramie Map PDF");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

}

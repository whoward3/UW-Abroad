package com.example.sapApp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class incomingHomePageFragment extends Fragment {

    Button about, laramie, degree, laramieMap;

    public incomingHomePageFragment() {} // SB:Required empty public constructor

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
                xml_resource_fragment nextFrag= new xml_resource_fragment(1);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, nextFrag, "UW Facts Fragment");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        laramie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //CS: Connection to the laramie Facts fragment
                xml_resource_fragment nextFrag= new xml_resource_fragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, nextFrag, "Laramie Fragment");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        degree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //CS: Connection to the Degree Fragment
                majorFragment nextFrag= new majorFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, nextFrag, "Degree Fragment");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        laramieMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //CS: Connection to the Laramie Map Fragment
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

public <T> void fragmentTransition(T nextFrag, String tag)
{

}

}

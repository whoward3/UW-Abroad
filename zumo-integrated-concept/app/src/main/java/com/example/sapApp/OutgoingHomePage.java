package com.example.sapApp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class OutgoingHomePage extends Fragment {

    Button consider, explore, prepare, whileAbd, return2Uw;

    public OutgoingHomePage() {} // SB: Required empty public constructor




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //SB: Set Up the View & Buttons
        View view = inflater.inflate(R.layout.fragment_outgoing_home_page, container, false);

        consider = view.findViewById(R.id.considerButton);
        explore = view.findViewById(R.id.exploreButton);
        prepare = view.findViewById(R.id.prepareButton);
        whileAbd = view.findViewById(R.id.whileAbroadButton);
        return2Uw = view.findViewById(R.id.return2UWButton);


        consider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SB: Directed to a blank page on the wireframe so oyu can ignore this one for now
                //Frag nextFrag= new Frag();
//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.content_frame, nextFrag, "_ Fragment");
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();
            }
        });

        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SB: Set Up Connection Here to a recycler view of what ethan made
                SchoolActivity nextFrag= new SchoolActivity();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, nextFrag, "_ Fragment");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        prepare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SB: Directed to a blank page on the wireframe so oyu can ignore this one for now
                HTMLfrag nextFrag= new HTMLfrag("https://www.uwyo.edu/");
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, nextFrag, "_ Fragment");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        whileAbd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SB: Directed to a blank page on the wireframe so oyu can ignore this one for now
                //Frag nextFrag= new Frag();
//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.content_frame, nextFrag, "_ Fragment");
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();
            }
        });

        return2Uw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SB: Directed to a blank page on the wireframe so oyu can ignore this one for now
                //Frag nextFrag= new Frag();
//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.content_frame, nextFrag, "_ Fragment");
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();
            }
        });
        return view;
    }

}

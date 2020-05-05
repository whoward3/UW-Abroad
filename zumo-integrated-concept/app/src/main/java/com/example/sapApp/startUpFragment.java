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
    This class is used to view the startup homepage.
    It has a small welcome message and 2 buttons.
    Those buttons are:
            - To the Incoming page
            - To the Outgoing Page
        -Alice Blair April 28, 2020
 */

public class startUpFragment extends Fragment {

    Button incoming, outgoing;

    //AB: Required empty public constructor
    public startUpFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //AB: Set Up the View and buttons
        View view = inflater.inflate(R.layout.fragment_start_up_page, container, false);
        incoming = view.findViewById(R.id.incomingButton);
        outgoing = view.findViewById(R.id.outGoingButton);

        /*
            Below are the on click listeners for all of the buttons.
            If we could condense and reuse the code that would be optimal,
            but it broke when we tried to condense it.
            Thus, for right now it is a big paragraph for each one.
                - Alice Blair April 28, 2020
         */

        //AB: Creates the path for the incoming home page
        incoming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incomingHomePageFragment nextFrag= new incomingHomePageFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, nextFrag, "Incoming Home Page");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        //AB: Creates the path for the outgoing home page
        outgoing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outgoingHomePageFragment nextFrag= new outgoingHomePageFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, nextFrag, "Outgoing Home Page");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

}

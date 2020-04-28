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
    This class is used to view the outgoing homepage.
    It has a small welcome message and 4 buttons.
    Those buttons are:
            - A Virtual Information page
            - An Explore Options Page
            - A Prepare Page
            - An Education Abroad Handbook
        -Alice Blair April 28, 2020
 */

public class outgoingHomePageFragment extends Fragment {

    Button virtualInfoButton, exploreOptionButton, prepareButton, educationAbroadHandbookButton;

    // AB: Required empty public constructor
    public outgoingHomePageFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //AB: Set Up the View & Buttons
        View view = inflater.inflate(R.layout.fragment_outgoing_home_page,
                container, false);
        virtualInfoButton = view.findViewById(R.id.virtualInfoButton);
        exploreOptionButton = view.findViewById(R.id.exploreButton);
        prepareButton = view.findViewById(R.id.prepareButton);
        educationAbroadHandbookButton = view.findViewById(R.id.educationAbroadHandbookButton);

         /*
            Below are the on click listeners for all of the buttons.
            If we could condense and reuse the code that would be optimal,
            but it broke when we tried to condense it.
            Thus, for right now it is a big paragraph for each one.
                - Alice Blair April 28, 2020
         */

        //AB: This creates and opens a html viewer fragment and passes it a link.
        //AB: The link is for the virtual information provided by the Abroad Office.
        virtualInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                htmlViewerFragment nextFrag= new htmlViewerFragment(
                        "https://vimeo.com/showcase/4410332");
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, nextFrag,
                        "Virtual Info");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        //AB: This creates and a school fragment and displays the most popular options.
        exploreOptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                schoolFragment nextFrag= new schoolFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, nextFrag,
                        "Explore Options");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        //AB: This creates and opens a html viewer fragment and passes it a link.
        //AB: The link is for the steps to apply provided by the Abroad Office.
        prepareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                htmlViewerFragment nextFrag= new htmlViewerFragment(
                        "http://www.uwyo.edu/uwyoabroad/application-process/index.html");
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, nextFrag,
                        "Prepare to go abroad");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        //AB: This creates and opens a PDF viewer fragment and passes nothing.
        //AB: Nothing = Education Abroad Handbook, aka the default case.
        educationAbroadHandbookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pdfViewerFragment nextFrag= new pdfViewerFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, nextFrag,
                        "Education Abroad Handbook");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return view;
    }

}

package com.example.sapApp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class outgoingHomePageFragment extends Fragment {

    Button virtualInfoButton, exploreOptionButton, prepareButton, educationAbroadHandbookButton;

    public outgoingHomePageFragment() {} // SB: Required empty public constructor




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //SB: Set Up the View & Buttons
        View view = inflater.inflate(R.layout.fragment_outgoing_home_page,
                container, false);

        virtualInfoButton = view.findViewById(R.id.virtualInfoButton);
        exploreOptionButton = view.findViewById(R.id.exploreButton);
        prepareButton = view.findViewById(R.id.prepareButton);
        educationAbroadHandbookButton = view.findViewById(R.id.educationAbroadHandbookButton);


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

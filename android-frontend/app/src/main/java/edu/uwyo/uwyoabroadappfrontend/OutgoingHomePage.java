//OutgoingHomePage.java
package edu.uwyo.uwyoabroadappfrontend;
/*
Created By S Blair
Nov 12 2019
Created Outgoing Home page and the respective XML file
This shows after outgoing is clicked on the home page
Still need to add the picture that was on the wireframe
 */

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class OutgoingHomePage extends Fragment {


    public OutgoingHomePage() {} // SB: Required empty public constructor




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //SB: Set Up the View
        View view = inflater.inflate(R.layout.fragment_outgoing_home_page, container, false);
        return view;
    }

}

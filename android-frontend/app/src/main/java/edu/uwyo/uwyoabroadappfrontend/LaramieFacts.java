//LaramieFacts.java
package edu.uwyo.uwyoabroadappfrontend;
/*
Created By S Blair
Nov 12 2019
Created Laramie Facts page and the respective XML file
This shows facts about laramie
this could be modified later to read from a file or database to fill it out
Still need to add the picture that was on the wireframe
 */
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class LaramieFacts extends Fragment {


    public LaramieFacts() {} // SB:Required empty public constructor




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //SB: Set Up the View
        View view = inflater.inflate(R.layout.fragment_laramie_facts, container, false);
        return view;
    }

}

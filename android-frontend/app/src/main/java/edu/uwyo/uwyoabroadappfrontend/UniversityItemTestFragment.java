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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;


public class UniversityItemTestFragment extends Fragment {


    public UniversityItemTestFragment() {} // SB:Required empty public constructor




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //SB: Set Up the View
        View view = inflater.inflate(R.layout.university_item_test_fragment, container, false);
        return view;
    }

}

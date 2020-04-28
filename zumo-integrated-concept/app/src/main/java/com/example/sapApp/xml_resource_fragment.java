package com.example.sapApp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

/*
    This class is used to view the various XMLs made.

    This class uses a switch statement to figure out which page to use.
        -Alice Blair April 28, 2020
 */

public class xml_resource_fragment extends Fragment {

    //AB: An integer for a switch statement where the integer indicates the case
    private int xmlCase= 0;

    public xml_resource_fragment() {} //AB: Required empty public constructor

    //AB: Constructor for the user to figure out which xml layout to use
    public xml_resource_fragment(int xmlCase)
    {
        this.xmlCase = xmlCase;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        switch (xmlCase)
        {
            case 1:
                view = inflater.inflate(R.layout.fragment_uw_facts, container, false);
                break;
            default:
                view = inflater.inflate(R.layout.fragment_laramie_facts, container, false);
                break;
        }

        return view;
    }

}

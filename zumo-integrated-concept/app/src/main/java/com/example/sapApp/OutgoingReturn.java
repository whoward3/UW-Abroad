package com.example.sapApp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class OutgoingReturn extends Fragment {

    public OutgoingReturn() {} // CS: Required empty public constructor

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //CS: Set up the View
        View view = inflater.inflate(R.layout.fragment_outgoing_return, container, false);

        return view;
    }
}

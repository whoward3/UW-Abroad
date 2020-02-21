package com.example.zumoappname;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

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

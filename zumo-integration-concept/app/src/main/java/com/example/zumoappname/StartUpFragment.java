package com.example.zumoappname;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class StartUpFragment extends Fragment {

    Button incoming, outgoing;


    public StartUpFragment() {}// SB: Required empty public constructor




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //SB: Set Up the View and buttons
        View view = inflater.inflate(R.layout.fragment_start_up_page, container, false);
        incoming = view.findViewById(R.id.incomingButton);
        outgoing = view.findViewById(R.id.outGoingButton);


        incoming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SB: Set Up Connection Here to the incoming home page
            }
        });

        outgoing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SB: Set Up Connection Here to the outgoing home page
            }
        });


        return view;
    }

}

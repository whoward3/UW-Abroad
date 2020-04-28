package com.example.sapApp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class startUpFragment extends Fragment {

    Button incoming, outgoing;


    public startUpFragment() {}// SB: Required empty public constructor




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //SB: Set Up the View and buttons
        View view = inflater.inflate(R.layout.fragment_start_up_page, container, false);
        incoming = view.findViewById(R.id.incomingButton);
        outgoing = view.findViewById(R.id.outGoingButton);
        ImageView imageView = new ImageView(getContext());

        //imageView.setImageRes;


        incoming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                incomingHomePageFragment nextFrag= new incomingHomePageFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, nextFrag, "e");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        outgoing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outgoingHomePageFragment nextFrag= new outgoingHomePageFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, nextFrag, "Incoming Home Page");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });


        return view;
    }

}

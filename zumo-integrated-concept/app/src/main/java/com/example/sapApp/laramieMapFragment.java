package com.example.sapApp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;



//Open Source Software
import com.github.barteksc.pdfviewer.PDFView;

public class laramieMapFragment extends Fragment {

    PDFView pdfView;



    public laramieMapFragment() {} // SB:Required empty public constructor




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //SB: Set Up the View
        View view = inflater.inflate(R.layout.laramie_map, container, false);

        //CS: To prevent fragments from being displayed over each other
        if (container != null) {
            container.removeAllViews();
        }

        pdfView = view.findViewById(R.id.pdfView);
        pdfView.fromAsset("gatewaycampusmap.pdf").load();

        return view;
    }


}




package com.example.sapApp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.github.barteksc.pdfviewer.PDFView;

/*
    This class is used to view a PDF using 3rd party code.
    The owner and source of that code is at:
    https://github.com/barteksc/AndroidPdfViewer

    This class's current implementation only reads and opens two PDFs.
    Those PDFs are the Education Abroad Handbook and the University of Wyoming Laramie Campus map.
        -Alice Blair April 28, 2020
 */


public class pdfViewerFragment extends Fragment {

    PDFView pdfView;

    //An integer for a switch statement where the integer indicates the case
    int pdfCase= 0;

    // AB:Required empty public constructor
    public pdfViewerFragment() {}

    // AB:Constructor to change which PDF is loaded
    public pdfViewerFragment(int pdfCase)
    {
        this.pdfCase = pdfCase;
    }
/*
    In theory this could be expanded more, if there are multiple PDFs.
    One could add a switch statement and depending on the value passed it opens a different PDF.
        - Alice Blair
 */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //AB: Set Up the View and find the PDF viewer
        View view = inflater.inflate(R.layout.fragment_pdf_viewer, container, false);
        pdfView = view.findViewById(R.id.pdfView);

        //This line passes the name of the pdf that is desired to be opened.
        //The files are located in the assets folder.
        switch (pdfCase)
        {
            case 1:
                pdfView.fromAsset("uw_laramie_campus.pdf").load();
            default:
                pdfView.fromAsset("educationAbroadHandbook.pdf").load();
        }

        return view;
    }

}

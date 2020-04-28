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

    This classes current implementation only reads and opens one pdf.
    That pdf is the Education Abroad Handbook.
        -Alice Blair April 28, 2020
 */


public class pdfViewerFragment extends Fragment {

    PDFView pdfView;

    // AB:Required empty public constructor

    public pdfViewerFragment() {}
/*
    In theory this could be expanded if there are multiple PDFs.
    One could add a switch statement and depending on the value passed it opens a different PDF.
 */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //AB: Set Up the View and find the PDF viewer
        View view = inflater.inflate(R.layout.fragment_pdf_viewer, container, false);
        pdfView = view.findViewById(R.id.pdfView);

        //This line passes the name of the pdf that is desired to be opened.
        //The file is located in the assets folder.
        pdfView.fromAsset("educationAbroadHandbook.pdf").load();

        return view;
    }

}

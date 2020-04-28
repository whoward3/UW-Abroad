package com.example.sapApp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.fragment.app.Fragment;

/*
    This class is used to view a HTML using 3rd party code.
    The owner and source of that code is at:
    https://square.github.io/okhttp/#get-a-url

    This class is opening various web-pages on the study abroad website.
    Most of the URLs are stored in the database and can be changed using the website.
    There are a few HTML links that are hard coded that can be found in the strings section.
        -Alice Blair April 28, 2020
 */

public class htmlViewerFragment extends Fragment {

    private WebView wv1;

    //AB: Used a default string which is the University of Wyoming Website Home Page
    private String URL = "https://www.uwyo.edu/";

    //AB: Basic constructor that takes a string and sets that as the URL.
    public htmlViewerFragment(String url) {
        URL = url;
    }

    //AB: Required Empty Constructor
    public htmlViewerFragment() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //AB: This sets up the web-viewer by calling a function in a separate class
        View view = inflater.inflate(R.layout.fragment_html_viewer, container, false);
        wv1 = view.findViewById(R.id.htmlViewerLoader);
        wv1.setWebViewClient(new htmlViewerLoaderFragment());

        //AB: These load the actual web-page properties on the phone
        wv1.getSettings().setLoadsImagesAutomatically(true);
        wv1.getSettings().setJavaScriptEnabled(true);
        wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        wv1.loadUrl(URL);

        return view;
    }

}

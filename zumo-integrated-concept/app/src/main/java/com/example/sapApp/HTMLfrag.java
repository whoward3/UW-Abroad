package com.example.sapApp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.fragment.app.Fragment;

public class HTMLfrag extends Fragment {

    private WebView wv1;
    private String URL = "https://www.uwyo.edu/";



    public HTMLfrag(String url){
        URL = url;

    }

    public HTMLfrag() {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_html, container, false);

        wv1= view.findViewById(R.id.Schoolhtmlviewer);
        wv1.setWebViewClient(new SchoolHTMLviewer());

        wv1.getSettings().setLoadsImagesAutomatically(true);
        wv1.getSettings().setJavaScriptEnabled(true);
        wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        wv1.loadUrl(URL);

        return view;
    }

}

package com.example.sapApp;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/*
    This class is used to view a HTML using 3rd party code.
    This is an extension of the htmlViewFragment.
    For whatever reason it would not allow me to combine this code with that class.
    This class quite literally only loads the URL.
        -Alice Blair April 28, 2020
 */

public class htmlViewerLoaderFragment extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        //AB: See? It only loads the URL
        view.loadUrl(url);
        return true;
    }
}

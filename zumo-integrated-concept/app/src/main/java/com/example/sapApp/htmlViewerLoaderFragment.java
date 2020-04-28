package com.example.sapApp;

import android.webkit.WebView;
import android.webkit.WebViewClient;




public class htmlViewerLoaderFragment extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
}

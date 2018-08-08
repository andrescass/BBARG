package com.bbarg.bloodborneargentina.bbarg.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.bbarg.bloodborneargentina.bbarg.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WebPageFragment extends Fragment {


    public WebPageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_web_page, container, false);

        WebView pageWebView = view.findViewById(R.id.web_page_webview);

        pageWebView.getSettings().setJavaScriptEnabled(true);

        pageWebView.loadUrl("https://sites.google.com/view/bloodborneargentina/");

        return view;
    }

}

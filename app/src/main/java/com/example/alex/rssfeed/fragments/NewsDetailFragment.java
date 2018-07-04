package com.example.alex.rssfeed.fragments;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.alex.rssfeed.App;

public class NewsDetailFragment extends Fragment {

    private WebView mWebView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mWebView = new WebView(getActivity());
        mWebView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mWebView.getSettings().setSupportZoom(true);
        mWebView.getSettings().setLoadsImagesAutomatically(true);
        mWebView.getSettings().setJavaScriptEnabled(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            mWebView.setWebViewClient(new WebViewClient() {
                @SuppressLint("NewApi")
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                    view.loadUrl(request.getUrl().getPath());
                    return super.shouldOverrideUrlLoading(view, request);
                }
            });
        }
        else {
            mWebView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }
            });
        }

        if (getArguments() != null && getArguments().containsKey(App.KEY_LINK)) {
            String url = getArguments().getString(App.KEY_LINK);
            showLink(url);
        }

        return mWebView;
    }

    public void showLink(String url) {
        mWebView.loadUrl(url);
    }
}

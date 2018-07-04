package com.example.alex.rssfeed;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class App extends Application {

    public static final String KEY_LINK = "KEY_LINK";

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        DataController.getInstance().initialize(getApplicationContext());
    }
}

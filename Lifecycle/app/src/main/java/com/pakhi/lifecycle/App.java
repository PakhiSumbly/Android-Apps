package com.pakhi.lifecycle;

import android.app.Application;
import android.util.Log;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("my_tag","APP onCreate called");
    }
}


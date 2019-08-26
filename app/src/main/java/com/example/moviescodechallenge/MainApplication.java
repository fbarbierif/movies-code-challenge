package com.example.moviescodechallenge;

import android.app.Application;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by fbarbieri on 2019-08-24.
 */
public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}

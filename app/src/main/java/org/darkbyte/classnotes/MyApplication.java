package org.darkbyte.classnotes;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

/**
 * Created by root on 10/3/17.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(getApplicationContext());

    }
}

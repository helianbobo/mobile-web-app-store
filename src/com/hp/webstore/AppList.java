package com.hp.webstore;

import android.os.Bundle;
import com.phonegap.DroidGap;

public class AppList extends DroidGap {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.loadUrl("file:///android_asset/main/applist.html");

    }
}
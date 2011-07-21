package com.hp.webstore;

import android.os.Bundle;
import com.phonegap.DroidGap;


public class LaunchAppActivity extends DroidGap {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String url = "file:///android_asset/apps/angrybirds/index.html";

        super.loadUrl(url);

    }

}

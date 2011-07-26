package com.hp.webstore;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.phonegap.DroidGap;

import java.io.File;


public class LaunchAppActivity extends DroidGap {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            String id = getIntent().getExtras().getString("id");
            File app1 = getDir("apps" + id, Context.MODE_PRIVATE);
            File[] files = app1.listFiles();
            if(files != null){
                for (int i = 0; i < files.length; i++) {
                    File file = files[i];
                    Log.d(this.getClass().getName(), file.getAbsolutePath());
                }
            }
            String url = "file:/" + app1.getAbsolutePath() + "/index.html";

            super.loadUrl(url);
        } catch (Exception e) {
            Log.e(this.getClass().getName(), e.getMessage());
        }


    }

}

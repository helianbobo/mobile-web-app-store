package com.hp.webstore;

import android.content.Intent;
import com.phonegap.api.Plugin;
import com.phonegap.api.PluginResult;
import org.json.JSONArray;

public class LaunchAppPlugin extends Plugin{

    @Override
    public PluginResult execute(String action, JSONArray args, String callbackId) {
        try {
            this.ctx.startActivity(new Intent(this.ctx, LaunchAppActivity.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new PluginResult(PluginResult.Status.OK);
    }
}

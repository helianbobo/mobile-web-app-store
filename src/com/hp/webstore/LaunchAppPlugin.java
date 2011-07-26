package com.hp.webstore;

import android.content.Intent;
import com.phonegap.api.Plugin;
import com.phonegap.api.PluginResult;
import org.json.JSONArray;
import org.json.JSONObject;

public class LaunchAppPlugin extends Plugin {

    @Override
    public PluginResult execute(String action, JSONArray args, String callbackId) {
        try {

            JSONObject obj = args.getJSONObject(0);
            String id = obj.has("id") ? obj.getString("id") : null;

            Intent intent = new Intent(this.ctx, LaunchAppActivity.class);
            intent.putExtra("id", id);
            this.ctx.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new PluginResult(PluginResult.Status.OK);
    }
}

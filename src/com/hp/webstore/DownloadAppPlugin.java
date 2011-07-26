package com.hp.webstore;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.util.Log;
import com.phonegap.api.Plugin;
import com.phonegap.api.PluginResult;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class DownloadAppPlugin extends Plugin {

    @Override
    public PluginResult execute(String action, JSONArray args, String callbackId) {
        try {
            if (args != null && args.length() > 0) {
                JSONObject obj = args.getJSONObject(0);
                String url = obj.has("url") ? obj.getString("url") : null;
                String id = obj.has("id") ? obj.getString("id") : null;
                download(id, url);

            } else {
                return new PluginResult(PluginResult.Status.ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new PluginResult(PluginResult.Status.OK);
    }

    private void download(String id, String urlString) {
        try {

            String appDir = "apps" + id;
            File fileAppDir = this.ctx.getDir(appDir, Context.MODE_PRIVATE);


            URL url = new URL(urlString);
            HttpURLConnection c = (HttpURLConnection) url.openConnection();
            c.setRequestMethod("GET");
            c.setDoOutput(true);
            c.connect();

            InputStream is = c.getInputStream();
            ZipInputStream zin = new ZipInputStream(is);
            ZipEntry ze = null;
            while ((ze = zin.getNextEntry()) != null) {
                Log.v("Decompress", "Unzipping " + ze.getName());

                File file = new File(fileAppDir.getAbsolutePath() + "/" + ze.getName());

                if (ze.isDirectory()) {

                    if (!file.isDirectory()) {
                        file.mkdirs();
                    }

                } else {
                    if(file.exists())
                        file.delete();
                    else
                        file.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    byte[] buffer = new byte[1024];
                    int len1 = 0;
                    while ((len1 = zin.read(buffer)) > 0) {
                        fileOutputStream.write(buffer, 0, len1);
                    }

                    zin.closeEntry();
                    fileOutputStream.close();
                    Log.v("Decompress", "Wrote " + file.getAbsolutePath());
                }

            }
            zin.close();
            is.close();
        } catch (IOException e) {
            Log.d("log_tag", "Error: " + e);
        }
    }
}

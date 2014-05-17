package com.example.imageloader.loader;

import java.net.URL;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;

public class ImageLoader extends AsyncTaskLoader<Drawable> {

    private String _url;

    public ImageLoader(Context context, String url) {
        super(context);
        this._url = url;
    }

    @Override
    public Drawable loadInBackground() {
        Drawable drawable = null;
        try {
            URL neturl = new URL(_url);
            drawable = Drawable.createFromStream(neturl.openStream(), "src");
        } catch (Exception e) {
            Log.e("ImageLoader", e.getMessage() + " : " + e);
        }
        return drawable;
    }

}

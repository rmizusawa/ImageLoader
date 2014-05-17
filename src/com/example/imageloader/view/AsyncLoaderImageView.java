package com.example.imageloader.view;

import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.Loader;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.example.imageloader.loader.ImageLoader;

public class AsyncLoaderImageView extends ImageView implements LoaderCallbacks<Drawable> {

    public AsyncLoaderImageView(Context context) {
        super(context);
    }

    public AsyncLoaderImageView(Context context, AttributeSet atts) {
        super(context, atts);
    }

    public AsyncLoaderImageView(Context context, AttributeSet atts, int defStyle) {
        super(context, atts, defStyle);
    }


    private String _url;

    public void setImageUrl(String url) {
        this._url = url;
    }

    @Override
    public Loader<Drawable> onCreateLoader(int id, Bundle bundle) {
        //if (bundle != null)Log.d(null, bundle.getString("test"));
        return new ImageLoader(getContext(), _url);
    }

    @Override
    public void onLoadFinished(Loader<Drawable> loader, Drawable drawable) {
        setImageDrawable(drawable);
    }

    @Override
    public void onLoaderReset(Loader<Drawable> loader) {
        // TODO 自動生成されたメソッド・スタブ

    }


}

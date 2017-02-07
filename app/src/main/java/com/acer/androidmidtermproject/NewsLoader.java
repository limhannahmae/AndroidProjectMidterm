package com.acer.androidmidtermproject;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Acer on 06/02/2017.
 */

public class NewsLoader extends AsyncTaskLoader<ArrayList<Article>> {

    private String mUrl;

    public NewsLoader(Context context, String mUrl) {
        super(context);
        this.mUrl = mUrl;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }


    @Override
    public ArrayList<Article> loadInBackground() {
        if(mUrl == null){
            return null;
        }

        ArrayList<Article> articles = QueryUtils.fetchNewsData(mUrl);
        return articles;
    }
}

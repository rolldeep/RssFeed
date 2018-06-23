package com.example.alex.rssfeed;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.example.alex.rssfeed.events.GetTechcrunchNewsEvent;
import com.example.alex.rssfeed.events.OfflineEvent;
import com.example.alex.rssfeed.news.Rss;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataController {

    private static DataController ourInstance;
    private static Context mContext;

    private final String TECHCRUNCH_OK_STATUS = "ok";

    public static DataController getInstance() {
        if (ourInstance == null) {
            ourInstance = new DataController();
        }
        return ourInstance;
    }

    private DataController(){

    }

    public static void initialize(Context context) {
        mContext = context.getApplicationContext();
    }

    public void getTechcrunchNewsFeed() {
        Log.i("DataController", "getTechcrunchNewsFeed()");
        if (!isOnline()) {
            EventBus.getDefault().post(new OfflineEvent());
            EventBus.getDefault().post(new GetTechcrunchNewsEvent(false, mContext.getString(R.string.offline_message), null));
            return;
        }

        TechCrunchApi techCrunchApi = TechCrunchApi.retrofit.create(TechCrunchApi.class);
        Call<Rss> getTechcrunchNewsFeedCall = techCrunchApi.getTechcrunchFeed();
        getTechcrunchNewsFeedCall.enqueue(new Callback<Rss>() {
            @Override
            public void onResponse(Call<Rss> call, Response<Rss> response) {
                Log.i("DataController", "getTechcrunchNewsFeed() - onResponse");
                Log.i("DataController", "getTechcrunchNewsFeed() - getItems().size()="+response.body().getChannel().getItems().size());
                EventBus.getDefault().post(new GetTechcrunchNewsEvent(response.isSuccessful(), response.message(), response.body()));
            }

            @Override
            public void onFailure(Call<Rss> call, Throwable t) {
                EventBus.getDefault().post(new GetTechcrunchNewsEvent(false, t.getMessage(), null));
                Log.i("DataController", "getNasaBreakingNewsFeed() - onFailure: "+t.getMessage());
            }
        });
    }

    private boolean isOnline() {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo =
                connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }
}

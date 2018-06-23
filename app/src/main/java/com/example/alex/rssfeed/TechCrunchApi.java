package com.example.alex.rssfeed;

import com.example.alex.rssfeed.news.Rss;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import retrofit2.http.GET;

public interface TechCrunchApi {

    final static String TECHCRUNCH_RSS_URL = "http://feeds.feedburner.com";

    @GET("/TechCrunch")
    Call<Rss> getTechcrunchFeed();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(TECHCRUNCH_RSS_URL)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build();
}

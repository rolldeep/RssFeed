package com.example.alex.rssfeed.events;

import com.example.alex.rssfeed.news.Rss;

public class GetTechcrunchNewsEvent {

    public boolean success;
    public String message;
    public Rss rss;

    public GetTechcrunchNewsEvent(boolean success, String message, Rss rss) {
        this.success = success;
        this.message = message;
        this.rss = rss;
    }
}

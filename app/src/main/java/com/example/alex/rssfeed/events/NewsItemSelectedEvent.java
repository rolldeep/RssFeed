package com.example.alex.rssfeed.events;

import com.example.alex.rssfeed.news.Item;

public class NewsItemSelectedEvent {
    public Item newsItem;
    public NewsItemSelectedEvent(Item newsItem) {
        this.newsItem = newsItem;
    }
}

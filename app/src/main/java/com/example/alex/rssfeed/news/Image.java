package com.example.alex.rssfeed.news;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Image", strict = false)
public class Image {

    @Element(name = "link")
    private String link;

    @Element(name = "url")
    private String url;

    @Element(name = "title")
    private String title;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

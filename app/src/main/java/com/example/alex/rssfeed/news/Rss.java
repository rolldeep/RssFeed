package com.example.alex.rssfeed.news;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Rss", strict = false)
public class Rss {

    @Attribute(name = "version")
    private String virsion;

    @Element(name = "channel")
    private Channel channel;

    public String getVirsion() {
        return virsion;
    }

    public void setVirsion(String virsion) {
        this.virsion = virsion;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }
}

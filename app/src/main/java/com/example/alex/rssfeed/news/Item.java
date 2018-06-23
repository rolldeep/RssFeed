package com.example.alex.rssfeed.news;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "Item", strict = false)
public class Item {

    @Element(name = "title")
    private String title;

    @Element(name = "link")
    private String link;

    @Element(name = "comments")
    private String comments;

    @Element(name = "pubDate")
    private String pubDate;

    @Element(data = true, name = "creator")
    private String creator;

    @Element(data = true, name = "description")
    private String description;

    @ElementList(entry = "category", inline = true)
    private List<Category> list;

    @Element(name = "guid")
    private Guid guid;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Category> getList() {
        return list;
    }

    public void setList(List<Category> list) {
        this.list = list;
    }

    public Guid getGuid() {
        return guid;
    }

    public void setGuid(Guid guid) {
        this.guid = guid;
    }
}

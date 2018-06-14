package com.example.alex.rssfeed.news;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.util.Entry;

import java.util.List;

@Root(name = "Item", strict = false)
public class Item {

    @Element(name = "title")
    private String title;

    @Element(name = "link")
    private String link;

    @Element(name = "comments")
    private String comments;

    @Element(name = "creator")
    private String creator;

    @ElementList(entry = "category", inline = true)
    private List<Category> list;
}

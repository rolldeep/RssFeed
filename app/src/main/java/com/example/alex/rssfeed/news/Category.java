package com.example.alex.rssfeed.news;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "catefory", strict = false)
public class Category {
    @Element(name = "category")
    private String category;
}

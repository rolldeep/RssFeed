package com.example.alex.rssfeed.news;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Category", strict = false)
public class Category {
    @Element(data = true, name = "category")
    private String category;
}

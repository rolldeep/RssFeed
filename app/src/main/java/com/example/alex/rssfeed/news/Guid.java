package com.example.alex.rssfeed.news;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Guid", strict = false)
public class Guid {

    @Element(name = "content")
    private String content;

    @Attribute(name = "isPermaLink", required = false)
    private String isPermaLink;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIsPermaLink() {
        return isPermaLink;
    }

    public void setIsPermaLink(String isPermaLink) {
        this.isPermaLink = isPermaLink;
    }

    @Override
    public String toString() {
        return "ClassPojo [content = "+content+", isPermaLink = "+isPermaLink+"]";
    }
}

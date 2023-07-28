package com.app.TestJava.models;

import lombok.Data;

@Data
public class ItemStories {
    private String resourceURI;
    private String name;
    private String type;

    public ItemStories(){}
    public ItemStories(String resourceURI, String name, String type) {
        this.resourceURI = resourceURI;
        this.name = name;
        this.type = type;
    }
}

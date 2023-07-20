package com.app.TestJava.models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ItemComic {
    private String resourceURI;
    private String name;
    public ItemComic() {}

    public ItemComic(String resourceURI, String name) {
        this.resourceURI = resourceURI;
        this.name = name;
    }

}

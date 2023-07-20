package com.app.TestJava.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemEvents {
    private String resourceURI;
    private String name;

    public ItemEvents(){}
    public ItemEvents(String resourceURI, String name) {
        this.resourceURI = resourceURI;
        this.name = name;
    }
}

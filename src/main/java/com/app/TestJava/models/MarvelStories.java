package com.app.TestJava.models;

import lombok.Data;

@Data
public class MarvelStories {
    private int available;
    private String collectionURI;
    private ItemStories[] items;
    private int returned;

    public MarvelStories(){}
    public MarvelStories(int available, String collectionURI, ItemStories[] items, int returned) {
        this.available = available;
        this.collectionURI = collectionURI;
        this.items = items;
        this.returned = returned;
    }
}

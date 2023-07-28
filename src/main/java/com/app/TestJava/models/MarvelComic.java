package com.app.TestJava.models;

import lombok.Data;

@Data
public class MarvelComic {
    private int available;
    private String collectionURI;
    private ItemComic[] items;
    private int returned;

    public MarvelComic(){}
    public MarvelComic(int available, String collectionURI, ItemComic[] items, int returned) {
        this.available = available;
        this.collectionURI = collectionURI;
        this.items = items;
        this.returned = returned;
    }
}

package com.app.TestJava.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarvelEvents {
    private int available;
    private String collectionURI;
    private ItemEvents[] items;
    private int returned;

    public MarvelEvents(){}
    public MarvelEvents(int available, String collectionURI, ItemEvents[] items, int returned) {
        this.available = available;
        this.collectionURI = collectionURI;
        this.items = items;
        this.returned = returned;
    }
}

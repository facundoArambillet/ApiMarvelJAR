package com.app.TestJava.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarvelSeries {
    private int available;
    private String collectionURI;
    private ItemSeries[] items;
    private int returned;

    public MarvelSeries(){}
    public MarvelSeries(int available, String collectionURI, ItemSeries[] items, int returned) {
        this.available = available;
        this.collectionURI = collectionURI;
        this.items = items;
        this.returned = returned;
    }
}

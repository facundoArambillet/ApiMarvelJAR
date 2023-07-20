package com.app.TestJava.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemSeries {
    private String resourceURI;
    private String name;
    public ItemSeries(){}
    public ItemSeries(String resourceURI, String name){
        this.resourceURI = resourceURI;
        this.name = name;
    }
}

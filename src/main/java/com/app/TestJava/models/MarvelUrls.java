package com.app.TestJava.models;

import lombok.Data;

@Data
public class MarvelUrls {
    private String type;
    private String url;

    public MarvelUrls(){}
    public MarvelUrls(String type, String url) {
        this.type = type;
        this.url = url;
    }
}

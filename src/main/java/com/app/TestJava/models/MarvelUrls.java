package com.app.TestJava.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarvelUrls {
    private String type;
    private String url;

    public MarvelUrls(){}
    public MarvelUrls(String type, String url) {
        this.type = type;
        this.url = url;
    }
}

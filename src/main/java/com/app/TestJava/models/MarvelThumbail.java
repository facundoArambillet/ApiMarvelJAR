package com.app.TestJava.models;

import lombok.Data;

@Data
public class MarvelThumbail {
    private String path;
    private String extension;

    public MarvelThumbail(){}
    public MarvelThumbail(String path, String extension) {
        this.path = path;
        this.extension = extension;
    }
}

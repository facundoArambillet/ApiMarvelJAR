package com.app.TestJava.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarvelThumbail {
    private String path;
    private String extension;

    public MarvelThumbail(){}
    public MarvelThumbail(String path, String extension) {
        this.path = path;
        this.extension = extension;
    }
}

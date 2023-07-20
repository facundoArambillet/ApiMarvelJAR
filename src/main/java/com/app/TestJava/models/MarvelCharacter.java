package com.app.TestJava.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarvelCharacter {
    private int id;
    private String name;
    private String description;
    private String modified;
    private MarvelThumbail thumbnail;
    private String resourceURI;
    private MarvelComic comics;
    private MarvelSeries series;
    private MarvelStories stories;
    private MarvelEvents events;
    private MarvelUrls[] urls;

    public MarvelCharacter() {}
    public MarvelCharacter(int id, String name, String description,String modified, MarvelThumbail thumbnail, String resourceURI, MarvelComic comics,
    MarvelSeries series, MarvelStories stories, MarvelEvents events, MarvelUrls[] urls) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.modified = modified;
        this.thumbnail = thumbnail;
        this.resourceURI = resourceURI;
        this.comics = comics;
        this.series = series;
        this.stories = stories;
        this.events = events;
        this.urls = urls;
    }
}

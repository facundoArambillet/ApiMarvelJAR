package com.app.TestJava.models;

import lombok.Data;

@Data
public class MarvelData {
    private int offset;
    private int limit;
    private int total;
    private int count;
    private MarvelCharacter[] results;

    public MarvelData(){}
    public MarvelData(int offset, int limit, int total, int count, MarvelCharacter[] results) {
        this.offset = offset;
        this.limit = limit;
        this.total = total;
        this.count = count;
        this.results = results;
    }
}

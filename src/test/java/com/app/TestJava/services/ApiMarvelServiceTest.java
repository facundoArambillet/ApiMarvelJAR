package com.app.TestJava.services;


import com.app.TestJava.models.MarvelModel;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ApiMarvelServiceTest {

    @Autowired
    private ApiMarvelService apiMarvelService;

//    @DisplayName("Test for get all")
//    @Test
//    public void getAll() {
//        MarvelModel[] characters = apiMarvelService.getAll();
//
//        assertThat(characters).isNotNull();
//        assertThat(characters).isNotEmpty();
//        assertThat(characters).allMatch(character -> character instanceof MarvelModel);
//    }
//
//    public void getById() {
//        MarvelModel character = apiMarvelService.getById(1);
//
//        assertThat(character).isNotNull();
//        assertThat(character).isInstanceOf(MarvelModel.class);
//    }

}

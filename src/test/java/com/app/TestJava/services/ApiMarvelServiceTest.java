package com.app.TestJava.services;


import com.app.TestJava.models.MarvelCharacter;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ApiMarvelServiceTest {

    @Autowired
    private ApiMarvelService apiMarvelService;

    @DisplayName("Test for get all")
    @Test
    public void getAll() {


        List<MarvelCharacter> characters = apiMarvelService.getAll();

        assertNotNull(characters, "The list of characters should not be null");

        assertTrue(!characters.isEmpty(), "The list of characters should not be empty");

        for (MarvelCharacter character : characters) {
            assertTrue(character instanceof MarvelCharacter, "Each element in the list should be an instance of MarvelCharacter");
        }
    }

    public void getById() {
        MarvelCharacter character = apiMarvelService.getById(1011334);

        assertNotNull(character,"The character should not be null");
        assertTrue(character.getId() > 0, "The character ID should be greather than 0");
        assertTrue(character instanceof MarvelCharacter, "The character should be an instance of MarvelCharacter");
    }

}

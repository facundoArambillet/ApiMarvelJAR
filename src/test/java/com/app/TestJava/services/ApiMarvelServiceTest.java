package com.app.TestJava.services;

import static org.junit.jupiter.api.Assertions.*;
import com.app.TestJava.models.MarvelCharacter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ApiMarvelServiceTest {

    @Autowired
    private ApiMarvelService apiMarvelService;

    @Test
    public void givenMarvelCharactersInDatabase_whenGetAllCharacters_thenListShouldNotBeEmpty() {
        List<MarvelCharacter> characters = this.apiMarvelService.getAll();

        assertNotNull(characters, "La lista de personajes no debería ser nula");
        assertFalse(characters.isEmpty(), "La lista de personajes no debería estar vacía");

        for (MarvelCharacter character : characters) {
            assertTrue(character instanceof MarvelCharacter, "Cada elemento en la lista debe ser una instancia de MarvelCharacter");
        }
    }

    @Test
    public void givenValidCharacterId_whenGetCharacterById_thenCharacterShouldNotBeNullAndShouldHaveValidId() {
        int characterId = 1011334;

        MarvelCharacter character = this.apiMarvelService.getById(characterId);

        assertNotNull(character, "El personaje no debería ser nulo");
        assertTrue(character.getId() > 0, "El ID del personaje debería ser mayor que 0");
        assertTrue(character instanceof MarvelCharacter, "El personaje debería ser una instancia de MarvelCharacter");
    }

    @Test
    public void givenInvalidCharacterId_whenGetCharacterById_thenCharacterShouldBeNull() {
        int characterId = -1;

        MarvelCharacter character = this.apiMarvelService.getById(characterId);

        assertNull(character, "El personaje debería ser nulo ya que el ID no existe");
    }


    @Test
    public void givenValidLimitAndOffset_whenGetByLimit_thenCharactersListShouldNotBeEmpty() {
        int limit = 10;
        int offset = 0;

        List<MarvelCharacter> characters = apiMarvelService.getByLimit(limit, offset);

        assertNotNull(characters, "La lista de personajes no debería ser nula");
        assertFalse(characters.isEmpty(), "La lista de personajes no debería estar vacía");
    }

}

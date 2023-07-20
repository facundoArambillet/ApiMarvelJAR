package com.app.TestJava.controllers;

import com.app.TestJava.models.MarvelApi;
import com.app.TestJava.models.MarvelCharacter;
import com.app.TestJava.services.ApiMarvelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Tiene que ser RestController para que funcione la documentacion en swagger
@RestController
@RequestMapping("/marvel")
public class ApiMarvelController {

    @Autowired
    private ApiMarvelService apiMarvelService;

    @Operation(summary = "Get all characters")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Characters found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MarvelCharacter.class)) }),

    })
    @GetMapping()
    public ResponseEntity<List<MarvelCharacter>> getAll() {
        if(apiMarvelService.getAll() != null) {
            return new ResponseEntity<List<MarvelCharacter>>(apiMarvelService.getAll(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<List<MarvelCharacter>>(apiMarvelService.getAll(), HttpStatus.NOT_FOUND);
        }
    }
    @Operation(summary = "Get a character by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the character",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MarvelCharacter.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Character not found",
                    content = @Content)

    })
    @GetMapping("/{characterId}")
    public ResponseEntity<MarvelCharacter> getById(@PathVariable("characterId") int id) {
        if(apiMarvelService.getById(id) != null) {
            return new ResponseEntity<MarvelCharacter>(apiMarvelService.getById(id), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<MarvelCharacter>(apiMarvelService.getById(id), HttpStatus.NOT_FOUND);
        }
    }

}

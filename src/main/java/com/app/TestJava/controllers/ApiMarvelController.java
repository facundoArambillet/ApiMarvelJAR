package com.app.TestJava.controllers;

import com.app.TestJava.models.MarvelModel;
import com.app.TestJava.services.ApiMarvelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;

@Controller
@RequestMapping("/marvel")
public class ApiMarvelController {

    @Autowired
    private ApiMarvelService apiMarvelService;
    @GetMapping()
    public ResponseEntity<Object[]> getAll() {
        if(apiMarvelService.getAll() != null) {
            return new ResponseEntity<Object[]>(apiMarvelService.getAll(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<Object[]>(apiMarvelService.getAll(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{characterId}")
    public ResponseEntity<MarvelModel> getById(@PathVariable("characterId") int id) {
        if(apiMarvelService.getById(id) != null) {
            return new ResponseEntity<MarvelModel>(apiMarvelService.getById(id), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<MarvelModel>(apiMarvelService.getById(id), HttpStatus.NOT_FOUND);
        }
    }

    //Cree estas clases para probar si la logica funcionaba con un mock real

//    @GetMapping("/all")
//    public ResponseEntity<Object[]> getAll() {
//        if(apiMarvelService.getAllTest() != null) {
//            return new ResponseEntity<Object[]>(apiMarvelService.getAllTest(), HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity<Object[]>(apiMarvelService.getAllTest(), HttpStatus.NOT_FOUND);
//        }
//    }
//    @GetMapping("/{characterId}")
//    public ResponseEntity<Object> getById(@PathVariable("characterId") int id) {
//        if(apiMarvelService.getByIdTest(id) != null) {
//            return new ResponseEntity<Object>(apiMarvelService.getByIdTest(id), HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity<Object>(apiMarvelService.getByIdTest(id), HttpStatus.NOT_FOUND);
//        }
//    }

}

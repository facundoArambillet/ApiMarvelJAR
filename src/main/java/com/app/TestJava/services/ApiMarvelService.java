package com.app.TestJava.services;

import com.app.TestJava.models.MarvelModel;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


@Service
public class ApiMarvelService {

    public MarvelModel[] getAll() {
        try {
            RestTemplate restTemplate = new RestTemplate();
                MarvelModel[] reponse = restTemplate.getForEntity("https://developer.marvel.com/v1/public/characters", MarvelModel[].class).getBody();
            return reponse;

        }
        catch (HttpClientErrorException e) {
            System.out.println(e);
            return null;
        }
    }
    public MarvelModel getById(int id) {
        try {
            String url = "https://v1/public/characters/" + id;
            RestTemplate restTemplate = new RestTemplate();
            MarvelModel reponse = restTemplate.getForEntity(url, MarvelModel.class).getBody();
            return reponse;

        }
        catch (HttpClientErrorException e) {
            System.out.println(e);
            return null;
        }
    }


    //Cree estas clases para probar si la logica funcionaba con un mock real

//    public Object[] getAllTest() {
//        try {
//            RestTemplate restTemplate = new RestTemplate();
//            Object[] reponse = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/todos", Object[].class).getBody();
//            return reponse;
//
//        }
//        catch (HttpClientErrorException e) {
//            System.out.println(e);
//            return null;
//        }
//    }
//    public Object getByIdTest(int id) {
//        try {
//            String url = "https://jsonplaceholder.typicode.com/todos/" + id;
//            RestTemplate restTemplate = new RestTemplate();
//            Object reponse = restTemplate.getForEntity(url, Object.class).getBody();
//            return reponse;
//
//        }
//        catch (HttpClientErrorException e) {
//            System.out.println(e);
//            return null;
//        }
//    }

}

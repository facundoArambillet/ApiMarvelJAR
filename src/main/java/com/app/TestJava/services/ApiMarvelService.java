package com.app.TestJava.services;

import com.app.TestJava.models.MarvelModel;
import com.app.TestJava.security.MarvelAuthentication;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;


@Service
public class ApiMarvelService {
    private final String baseUrl = "https://developer.marvel.com/v1/public/characters";
    private String apiKey = "1234";
    private String timestamp = String.valueOf(Instant.now().toEpochMilli());
    private String hash = MarvelAuthentication.generateHash();
//    public MarvelModel[] getAll() {
//        try {
//            RestTemplate restTemplate = new RestTemplate();
//            String url = baseUrl + "?ts=" + timestamp + "&apikey=" + apiKey + "&hash=" + hash;
//                MarvelModel[] reponse = restTemplate.getForEntity(url, MarvelModel[].class).getBody();
//            return reponse;
//
//        }
//        catch (HttpClientErrorException e) {
//            System.out.println(e);
//            return null;
//        }
//    }
    public Object[] getAll() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = this.baseUrl + "?ts=" + this.timestamp + "&apikey=" + this.apiKey + "&hash=" + this.hash;
            System.out.println(url);
            Object[] reponse = restTemplate.getForEntity(url, Object[].class).getBody();
            System.out.println(reponse);
            return reponse;

        }
        catch (HttpClientErrorException e) {
            System.out.println(e);
            return null;
        }
    }
    public MarvelModel getById(int id) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = baseUrl + "/" +id + "?ts=" + timestamp + "&apikey=" + apiKey + "&hash=" + hash;
            System.out.println(url);
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

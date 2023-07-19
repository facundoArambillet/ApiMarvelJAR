package com.app.TestJava.services;

import com.app.TestJava.models.MarvelModel;
import com.app.TestJava.security.MarvelAuthentication;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;


@Service
public class ApiMarvelService {
    private final String baseUrl = "https://gateway.marvel.com/v1/public/characters";
    //private final String baseUrl = "https://developer.marvel.com/v1/public/characters";
    private static String publicKey = "7de0a07897b8e56b7c99b8c5a8740055";
    private static String privateKey = "5f1040d9af2401040adc394489857e64c256414b";
    private String timestamp = String.valueOf(Instant.now().toEpochMilli()).substring(0,3);
    private String hash = MarvelAuthentication.generateHash(this.timestamp,this.privateKey,this.publicKey);

//    public MarvelModel[] getAll() {
//        try {
//            RestTemplate restTemplate = new RestTemplate();
//            String url = baseUrl + "?ts=" + this.timestamp + "&apikey=" + this.apiKey + "&hash=" + this.hash;
//            MarvelModel[] reponse = restTemplate.getForEntity(url, MarvelModel[].class).getBody();
//            return reponse;
//
//        }
//        catch (HttpClientErrorException e) {
//            System.out.println(e);
//            return null;
//        }
//    }

    public Object getAll() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = this.baseUrl + "?ts=" + this.timestamp + "&apikey=" + this.publicKey + "&hash=" + this.hash;
            System.out.println(url);
            Object reponse = restTemplate.getForEntity(url, Object.class).getBody();
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
            String url = baseUrl + "/" +id + "?ts=" + timestamp + "&apikey=" + publicKey + "&hash=" + hash;
            System.out.println(url);
            MarvelModel reponse = restTemplate.getForEntity(url, MarvelModel.class).getBody();

            return reponse;
        }
        catch (HttpClientErrorException e) {
            System.out.println(e);
            return null;
        }
    }

}

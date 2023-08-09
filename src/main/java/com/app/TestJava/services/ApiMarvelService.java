package com.app.TestJava.services;

import com.app.TestJava.models.MarvelApi;
import com.app.TestJava.models.MarvelCharacter;
import com.app.TestJava.security.MarvelAuthentication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@Service
public class ApiMarvelService {
    private final String baseUrl = "https://gateway.marvel.com/v1/public/characters";
    //private final String baseUrl = "https://developer.marvel.com/v1/public/characters";
    @Value("${publicKey}")
    private String publicKey;
    @Value("${privateKey}")
    private String privateKey;

    private String timestamp;
    private  String hash;

    public List<MarvelCharacter> getAll() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            timestamp = String.valueOf(Instant.now().toEpochMilli()).substring(0,3);
            hash = MarvelAuthentication.generateHash(this.timestamp,this.privateKey,this.publicKey);
            //Agregue el limit para que me traiga 100 en vez de los 20 que trae por default
            String url = this.baseUrl + "?limit=100" + "&ts=" + this.timestamp + "&apikey=" + this.publicKey + "&hash=" + this.hash;
            MarvelApi reponse = restTemplate.getForEntity(url, MarvelApi.class).getBody();
            List<MarvelCharacter> characters = new ArrayList<>();
            for(MarvelCharacter character : reponse.getData().getResults()) {
                characters.add(character);
            }
            return characters;

        }
        catch (HttpClientErrorException e) {
            System.out.println(e);
            return null;
        }
    }

    public List<MarvelCharacter> getByLimit(int limit, int offset) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            timestamp = String.valueOf(Instant.now().toEpochMilli()).substring(0,3);
            hash = MarvelAuthentication.generateHash(this.timestamp,this.privateKey,this.publicKey);
            String url = this.baseUrl + "?limit=" + limit + "&offset=" + offset  + "&ts=" + this.timestamp + "&apikey=" + this.publicKey + "&hash=" + this.hash;
            MarvelApi reponse = restTemplate.getForEntity(url, MarvelApi.class).getBody();
            List<MarvelCharacter> characters = new ArrayList<>();
            for(MarvelCharacter character : reponse.getData().getResults()) {
                characters.add(character);
            }
            return characters;

        }
        catch (HttpClientErrorException e) {
            System.out.println(e);
            return null;
        }
    }

    public MarvelCharacter getById(int id) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            timestamp = String.valueOf(Instant.now().toEpochMilli()).substring(0,3);
            hash = MarvelAuthentication.generateHash(this.timestamp,this.privateKey,this.publicKey);
            String url = baseUrl + "/" +id + "?ts=" + timestamp + "&apikey=" + publicKey + "&hash=" + hash;
            MarvelApi reponse = restTemplate.getForEntity(url, MarvelApi.class).getBody();
            //Agarro el primero porque siempre me va a devolver uno solo
            MarvelCharacter character = reponse.getData().getResults()[0];
            return character;
        }
        catch (HttpClientErrorException e) {
            System.out.println(e);
            return null;
        }
    }

}

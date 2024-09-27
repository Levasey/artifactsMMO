package org.example;

import org.apache.http.client.methods.HttpGet;


public class CreateGet {
    public static HttpGet createGet() {
        HttpGet httpGet = new HttpGet("https://api.artifactsmmo.com/characters/Vova");
        httpGet.addHeader("Accept", "application/json");
        return httpGet;
    }

}

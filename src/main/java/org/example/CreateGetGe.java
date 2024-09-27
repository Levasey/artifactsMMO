package org.example;

import org.apache.http.client.methods.HttpGet;

public class CreateGetGe {
    public static HttpGet createGetGe(String itemCode) {
        HttpGet httpGetItem = new HttpGet("https://api.artifactsmmo.com/ge/" + itemCode);
        httpGetItem.addHeader("Accept", "application/json");
        return httpGetItem;
    }
}

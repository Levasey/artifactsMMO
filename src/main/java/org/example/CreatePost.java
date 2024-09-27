package org.example;

import org.apache.http.client.methods.HttpPost;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CreatePost {
    public static HttpPost createPost(String action) {
        File file = new File("C:\\Users\\79043\\IdeaProjects\\artifactsClient\\Token");
        Scanner fileReader = null;
        try {
            fileReader = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        fileReader.hasNext();
        String token = fileReader.nextLine();
        HttpPost post = new HttpPost("https://api.artifactsmmo.com/my/Vova/action/" + action);
        post.addHeader("Accept", "application/json");
        post.addHeader("Content-Type", "application/json");
        post.addHeader("Authorization", "Bearer " + token);
        fileReader.close();
        return post;
    }

}

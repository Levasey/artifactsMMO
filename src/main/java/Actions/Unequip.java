package Actions;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.example.Client;
import org.example.CreatePost;
import org.example.Mapper;
import pojo.CooldownState;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Unequip {
    public static void unequip(String slot) throws UnsupportedEncodingException {
        String unequip = "unequip";
        HttpPost post = CreatePost.createPost(unequip);
        String name = "{\n" +
                "   \"slot\": \"" + slot + "\"\n" +
                "}";
        post.setEntity(new StringEntity(name));
        String response = null;
        try {
            response = Client.client(post);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Unequip" + slot);
        CooldownState cooldownState = Mapper.getCooldownState(response);
        try {
            Thread.sleep(cooldownState.total_seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

package Actions;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.example.Client;
import org.example.CreatePost;
import org.example.Mapper;
import pojo.CooldownState;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Equip {
    public static void equip(String item, String slot) throws UnsupportedEncodingException {
        HttpPost post = CreatePost.createPost("equip");
        String code = "{\n" +
                "  \"code\": \"" + item + "\",\n" +
                "  \"slot\": \"" + slot + "\"\n" +
                "}";
        post.setEntity(new StringEntity(code));
        String response = null;
        try {
            response = Client.client(post);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Equip" + item);
        CooldownState cooldownState = Mapper.getCooldownState(response);
        try {
            Thread.sleep(cooldownState.total_seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

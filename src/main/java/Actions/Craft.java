package Actions;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.example.Client;
import org.example.CreatePost;
import org.example.Mapper;
import pojo.CooldownState;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Craft {
    public static void crafting(String name) throws UnsupportedEncodingException {
        String crafting = "crafting";
        HttpPost post = CreatePost.createPost(crafting);
        String code = "{\n" +
                "   \"code\": \"" + name + "\"\n" +
                "}";
        post.setEntity(new StringEntity(code));
        String response = null;
        try {
            response = Client.client(post);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Crafting: " + name);
        CooldownState cooldownState = Mapper.getCooldownState(response);
        try {
            Thread.sleep(cooldownState.total_seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

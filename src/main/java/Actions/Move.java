package Actions;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.example.Client;
import org.example.CreatePost;
import org.example.Mapper;
import pojo.CooldownState;
import pojo.UniteState;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Move {
    public static void move(int x, int y) throws UnsupportedEncodingException {
        UniteState uniteState = GetCharacterInfo.getCharacterInfo();
        int x1 = uniteState.x;
        int y1 = uniteState.y;
        if (x1 == x && y1 == y) {
            return;
        }
        String action = "move";
        HttpPost post = CreatePost.createPost(action);
        String location = "{\"x\":" + x + ",\"y\":" + y + "}";
        post.setEntity(new StringEntity(location));
        String response = null;
        try {
            response = Client.client(post);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Move to x: " + x + " y: " + y);
        CooldownState cooldownState = Mapper.getCooldownState(response);
        try {
            Thread.sleep(cooldownState.total_seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("cooldown end");
    }
}
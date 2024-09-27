package Actions;

import org.apache.http.client.methods.HttpPost;
import org.example.Client;
import org.example.CreatePost;
import org.example.Mapper;
import pojo.CooldownState;

import java.io.IOException;

public class Attack {
    public static void fight(){
        String fight = "fight";
        HttpPost post = CreatePost.createPost(fight);
        String response = null;
        try {
            response = Client.client(post);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(response);
        CooldownState cooldown = Mapper.getCooldownState(response);
        try {
            Thread.sleep(cooldown.total_seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("cooldown end");
    }
}

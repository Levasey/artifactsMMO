package Actions;

import org.apache.http.client.methods.HttpPost;
import org.example.Client;
import org.example.CreatePost;
import org.example.Mapper;
import pojo.CooldownState;
import pojo.UniteState;

import java.io.IOException;

public class CollectResourses {
    public static UniteState gathering() {
        String gathering = "gathering";
        HttpPost post = CreatePost.createPost(gathering);
        String response = null;
        try {
            response = Client.client(post);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Collecting resources");
        CooldownState cooldownState = Mapper.getCooldownState(response);
         try {
            Thread.sleep(cooldownState.total_seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("cooldown end");
        return Mapper.getUniteStataAfterAction(response);
    }
}

package Actions;

import org.apache.http.client.methods.HttpGet;
import org.example.Client;
import org.example.CreateGet;
import org.example.Mapper;
import pojo.UniteState;

import java.io.IOException;

public class GetCharacterInfo {
    public static UniteState getCharacterInfo() {
        HttpGet httpGet = CreateGet.createGet();
        String response = null;
        try {
            response = Client.client(httpGet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        UniteState uniteState = Mapper.getCharacter(response);
        return uniteState;
    }
}

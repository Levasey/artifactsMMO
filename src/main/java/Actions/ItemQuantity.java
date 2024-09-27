package Actions;

import org.apache.http.client.methods.HttpGet;
import org.example.Client;
import org.example.CreateGet;
import org.example.Mapper;
import pojo.UniteState;

import java.io.IOException;

public class ItemQuantity {
    public static int itemQuantity(String itemCode){
        HttpGet httpGet = CreateGet.createGet();
        String response = null;
        try {
            response = Client.client(httpGet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        UniteState uniteState = Mapper.getCharacter(response);
        int quantity = uniteState.getQuantity(itemCode);
        return quantity;
    }
}

package Actions;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.example.Client;
import org.example.CreatePost;
import org.example.Mapper;
import pojo.CooldownState;


import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class GeSellItem {
    public static void geSellItem(String itemCode) throws UnsupportedEncodingException {
        HttpPost post = CreatePost.createPost("ge/sell");
        int itemQuantity = ItemQuantity.itemQuantity(itemCode);
        int itemSelPrice = SellPrice.sellPrice(itemCode);
        String code = "{\n" +
                "  \"code\": \"" + itemCode + "\",\n" +
                "  \"quantity\": " + itemQuantity + ",\n" +
                "  \"price\": " + itemSelPrice + "\n" +
                "}";
        post.setEntity(new StringEntity(code));
        String response = null;
        try {
            response = Client.client(post);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Sell: " + itemCode);
        CooldownState cooldownState = Mapper.getCooldownState(response);
        try {
            Thread.sleep(cooldownState.total_seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

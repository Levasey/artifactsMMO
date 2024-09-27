package Actions;

import org.apache.http.client.methods.HttpGet;
import org.example.Client;
import org.example.CreateGetGe;
import org.example.Mapper;
import pojo.GeState;

import java.io.IOException;

public class SellPrice {
    public static int sellPrice(String itemCode){
        HttpGet httpGetItem = CreateGetGe.createGetGe(itemCode);
        String response = null;
        try {
            response = Client.client(httpGetItem);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        GeState ge = Mapper.getGe(response);
        int selPrice = ge.sell_price;
        return selPrice;
    }
}

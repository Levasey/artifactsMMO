package Items;

import Actions.Attack;
import Actions.Craft;
import Actions.ItemQuantity;
import Actions.Move;

import java.io.UnsupportedEncodingException;

public class FeatherCoat {
    public static void featherCoat() throws UnsupportedEncodingException {
        Move.move(0, 1);
        int quantityRawChicken = ItemQuantity.itemQuantity("raw_chicken");
        int quantityFeather = ItemQuantity.itemQuantity("feather");
        while (quantityFeather < 6) {
            Attack.fight();
            quantityFeather = ItemQuantity.itemQuantity("feather");
            System.out.println("raw_chicken: " + ItemQuantity.itemQuantity("raw_chicken"));
            System.out.println("feather: " + ItemQuantity.itemQuantity("feather"));
            System.out.println("egg: " + ItemQuantity.itemQuantity("egg"));
            System.out.println("golden_egg: " + ItemQuantity.itemQuantity("golden_egg"));
        }
        Move.move(1, 1);
        for (int i = 0; i < quantityRawChicken; i++) {
            Craft.crafting("cooked_chicken");
        }
        Move.move(3, 1);
        Craft.crafting("feather_coat");
    }
}

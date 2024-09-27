package Items;

import Actions.Attack;
import Actions.Craft;
import Actions.ItemQuantity;
import Actions.Move;

import java.io.UnsupportedEncodingException;

public class LifeAmulet {
    public static void lifeAmulet() throws UnsupportedEncodingException {
        int quantityRawChicken = ItemQuantity.itemQuantity("raw_chicken");
        int quantityFeather = ItemQuantity.itemQuantity("feather");
        Move.move(0, 1);
        while (quantityFeather < 4) {
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
        int quantityRedSlimeball = ItemQuantity.itemQuantity("red_slimeball");
        while (quantityRedSlimeball < 2) {
            Attack.fight();
            System.out.println("RedSlimeball: " + ItemQuantity.itemQuantity("red_slimeball"));
            quantityRedSlimeball = ItemQuantity.itemQuantity("red_slimeball");
        }
        int quantityBlueSlimeball = ItemQuantity.itemQuantity("blue_slimeball");
        while (quantityBlueSlimeball < 2) {
            Attack.fight();
            System.out.println("Blue slimeball: " + ItemQuantity.itemQuantity("blue_slimeball"));
            quantityBlueSlimeball = ItemQuantity.itemQuantity("blue_slimeball");
        }
        Move.move(1, 3);
        Craft.crafting("life_amulet");
    }
}

package Items;

import Actions.*;

import java.io.UnsupportedEncodingException;

public class CopperArmor {
    public static void copperArmor() throws UnsupportedEncodingException {
        Move.move(0, 1);
        int quantityRawChicken = ItemQuantity.itemQuantity("raw_chicken");
        int quantityFeather = ItemQuantity.itemQuantity("feather");
        while (quantityFeather < 2) {
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
        Move.move(2, 0);
        int quantityCopperRocks = ItemQuantity.itemQuantity("copper_ore");
        int quantityCopper = ItemQuantity.itemQuantity("copper");
        while (quantityCopperRocks < 40) {
            CollectResourses.gathering();
            quantityCopperRocks = ItemQuantity.itemQuantity("copper_ore");
            System.out.println("copper_ore quantity: " + quantityCopperRocks);
        }
        Move.move(1, 5);
        while (quantityCopper < 5) {
            Craft.crafting("copper");
            quantityCopper = ItemQuantity.itemQuantity("copper");
            System.out.println("copper quantity: " + quantityCopper);
        }
        Move.move(3, 1);
        Craft.crafting("copper_armor");
    }
}

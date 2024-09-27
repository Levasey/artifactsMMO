package Items;

import Actions.*;

import java.io.UnsupportedEncodingException;

public class CopperDagger {
    public static void copperDagger() throws UnsupportedEncodingException {
        int quantityCopperRocks = ItemQuantity.itemQuantity("copper_ore");
        int quantityCopper = ItemQuantity.itemQuantity("copper");
        Move.move(2, 0);
        while (quantityCopperRocks < 48) {
            CollectResourses.gathering();
            quantityCopperRocks = ItemQuantity.itemQuantity("copper_ore");
            System.out.println("copper_ore quantity: " + quantityCopperRocks);
        }
        Move.move(1, 5);
        while (quantityCopper < 6) {
            Craft.crafting("copper");
            quantityCopper = ItemQuantity.itemQuantity("copper");
            System.out.println("copper quantity: " + quantityCopper);
        }
        Move.move(2, 1);
        Craft.crafting("copper_dagger");
//        Equip.equip("copper_dagger", "weapon");
    }
}

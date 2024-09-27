package Items;

import Actions.*;

import java.io.UnsupportedEncodingException;

public class StickyDagger {
    public static void stickyDagger() throws UnsupportedEncodingException {
        int quantityCopperRocks = ItemQuantity.itemQuantity("copper_ore");
        int quantityCopper = ItemQuantity.itemQuantity("copper");
        int quantityGreenSlimeball = ItemQuantity.itemQuantity("green_slimeball");
        Move.move(0, -1);
        while (quantityGreenSlimeball < 2) {
            Attack.fight();
            System.out.println("Green Slimeball: " + ItemQuantity.itemQuantity("green_slimeball"));
            quantityGreenSlimeball = ItemQuantity.itemQuantity("green_slimeball");
        }
        Move.move(2, 0);
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
        Move.move(2, 1);
        Craft.crafting("sticky_dagger");
    }
}

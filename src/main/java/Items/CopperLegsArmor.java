package Items;

import Actions.CollectResourses;
import Actions.Craft;
import Actions.ItemQuantity;
import Actions.Move;

import java.io.UnsupportedEncodingException;

public class CopperLegsArmor {
    public static void copperLegsArmor() throws UnsupportedEncodingException {
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
        Move.move(3, 1);
        Craft.crafting("copper_legs_armor");
    }
}

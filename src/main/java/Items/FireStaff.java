package Items;

import Actions.*;

import java.io.UnsupportedEncodingException;

public class FireStaff {
    public static void fireStaff() throws UnsupportedEncodingException {
        int quantityRedSlimeball = ItemQuantity.itemQuantity("red_slimeball");
        int quantityAshWood = ItemQuantity.itemQuantity("ash_wood");
        int quantityAshPlank = ItemQuantity.itemQuantity("ash_plank");
        Move.move(1, -1);
        while (quantityRedSlimeball < 2) {
            Attack.fight();
            System.out.println("RedSlimeball: " + ItemQuantity.itemQuantity("red_slimeball"));
            quantityRedSlimeball = ItemQuantity.itemQuantity("red_slimeball");
        }
        Move.move(-1, 0);
        while (quantityAshWood < 40) {
            CollectResourses.gathering();
            System.out.println("Quantity of Ash Wood: " + ItemQuantity.itemQuantity("ash_wood"));
            quantityAshWood = ItemQuantity.itemQuantity("ash_wood");
        }
        Move.move(-2, -3);
        while (quantityAshPlank < 5) {
            Craft.crafting("ash_plank");
            System.out.println("Quantity of Ash Plank: " + ItemQuantity.itemQuantity("ash_plank"));
            quantityAshPlank = ItemQuantity.itemQuantity("ash_plank");
        }
        Move.move(2, 1);
        Craft.crafting("fire_staff");
    }
}

package Items;

import Actions.*;

import java.io.UnsupportedEncodingException;

public class WaterBow {
    public static void waterBow() throws UnsupportedEncodingException{
        int quantityBlueSlimeball = ItemQuantity.itemQuantity("blue_slimeball");
        int quantityAshWood = ItemQuantity.itemQuantity("ash_wood");
        int quantityAshPlank = ItemQuantity.itemQuantity("ash_plank");
        Move.move(2, -1);
        while (quantityBlueSlimeball < 2) {
            Attack.fight();
            System.out.println("Blue slimeball: " + ItemQuantity.itemQuantity("blue_slimeball"));
            quantityBlueSlimeball = ItemQuantity.itemQuantity("blue_slimeball");
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
        Craft.crafting("water_bow");
    }
}

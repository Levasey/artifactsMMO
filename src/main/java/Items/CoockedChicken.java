package Items;

import Actions.Attack;
import Actions.Craft;
import Actions.ItemQuantity;
import Actions.Move;

import java.io.IOException;

public class CoockedChicken {
    public static void main(String[] args) throws IOException, NullPointerException {
        Move.move(0, 1);
        int quantityRawChicken = ItemQuantity.itemQuantity("raw_chicken");
        int quantityFeather = ItemQuantity.itemQuantity("feather");
        int quantityEgg = ItemQuantity.itemQuantity("egg");
        int quantityGoldenEgg = ItemQuantity.itemQuantity("golden_egg");
        while (quantityRawChicken < 100) {
            Attack.fight();
            quantityRawChicken = ItemQuantity.itemQuantity("raw_chicken");
            System.out.println("raw_chicken: " + quantityRawChicken);
            System.out.println("feather: " + quantityFeather);
            System.out.println("egg: " + quantityEgg);
            System.out.println("golden_egg: " + quantityGoldenEgg);
        }
        Move.move(1, 1);
        for (int i = 0; i < quantityRawChicken; i++) {
            Craft.crafting("cooked_chicken");
        }

        System.out.println("raw_chicken: " + quantityRawChicken);
        System.out.println("feather: " + quantityFeather);
        System.out.println("egg: " + quantityEgg);
        System.out.println("golden_egg: " + quantityGoldenEgg);
    }
}

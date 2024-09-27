package Task;

import Actions.*;
import pojo.UniteState;

import java.io.UnsupportedEncodingException;

public class LevelUpFishingLevel {
    public static void levelUpFishingLevel() throws UnsupportedEncodingException {
        UniteState uniteState = GetCharacterInfo.getCharacterInfo();
        int fishingLevel = uniteState.fishing_level;
        int inventory_max_items = uniteState.inventory_max_items;
        int quantityGudgeon = uniteState.getQuantity("gudgeon");
        while (fishingLevel < 10) {
            Move.move(4, 2);
            CollectResourses.gathering();
            System.out.println("Quantity of Gudgeon: " + uniteState.getQuantity("gudgeon"));
            fishingLevel = uniteState.fishing_level;
            inventory_max_items = uniteState.inventory_max_items;
            if (inventory_max_items == 0) {
                Move.move(1, 1);
                for (int i = 0; i < quantityGudgeon; i++) {
                    Craft.crafting("cooked_gudgeon");
                }
                Move.move(5, 1);
                GeSellItem.geSellItem("cooked_gudgeon");
            }
        }
        Move.move(1, 1);
        for (int i = 0; i < quantityGudgeon; i++) {
            Craft.crafting("cooked_gudgeon");
        }
    }
}

package Task;

import Actions.Equip;
import Actions.GeSellItem;
import Actions.GetCharacterInfo;
import Actions.Move;
import Items.CopperRing;
import Items.LifeAmulet;
import pojo.UniteState;

import java.io.UnsupportedEncodingException;

public class LevelUpJewelryCraftingLevel {
    public static void LevelUpJewelryCraftingLevel() throws UnsupportedEncodingException {
        UniteState uniteState = GetCharacterInfo.getCharacterInfo();
        System.out.println("Jewelry Crafting Level: " + uniteState.jewelrycrafting_level);
        int jewelryCraftingLevel = uniteState.jewelrycrafting_level;
        while (jewelryCraftingLevel < 5) {
            CopperRing.copperRing();
            Move.move(5, 1);
            GeSellItem.geSellItem("copper_ring");
            jewelryCraftingLevel = uniteState.jewelrycrafting_level;
            System.out.println("Jewelry Crafting Level: " + jewelryCraftingLevel);
            if (jewelryCraftingLevel == 5){
                LifeAmulet.lifeAmulet();
                Equip.equip("life_amulet", "amulet");
            }
        }
    }
}

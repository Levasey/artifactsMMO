package Task;

import Actions.*;
import Items.*;
import pojo.UniteState;

import java.io.UnsupportedEncodingException;

public class LevelUpWeaponcraftingLevel {
    public static void levelUpWeaponcraftingLevel() throws UnsupportedEncodingException {
        UniteState uniteState = GetCharacterInfo.getCharacterInfo();
        int weaponcraftingLevel = uniteState.weaponcrafting_level;
        System.out.println("WeaponcraftingLevel: " + weaponcraftingLevel);
        while (weaponcraftingLevel < 5) {
            CopperDagger.copperDagger();
            Move.move(5, 1);
            GeSellItem.geSellItem("copper_dagger");
            System.out.println("WeaponcraftingLevel: " + uniteState.weaponcrafting_level);
            weaponcraftingLevel = uniteState.weaponcrafting_level;
        }
        weaponcraftingLevel = uniteState.weaponcrafting_level;
        if (weaponcraftingLevel == 5) {
                StickyDagger.stickyDagger();
                Unequip.unequip("weapon");
                Equip.equip("sticky_dagger", "weapon");
                WaterBow.waterBow();
                Unequip.unequip("body_armor");
                Equip.equip("copper_armor", "body_armor");
                StickySword.stickySword();
                FireStaff.fireStaff();
            }
        System.out.println("WeaponcraftingLevel: " + uniteState.weaponcrafting_level);
        weaponcraftingLevel = uniteState.weaponcrafting_level;
    }
}

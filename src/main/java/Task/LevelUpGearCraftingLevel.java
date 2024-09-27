package Task;

import Actions.*;
import Items.CooperHelmet;
import Items.CopperArmor;
import Items.CopperLegsArmor;
import Items.FeatherCoat;
import pojo.UniteState;

import java.io.UnsupportedEncodingException;

public class LevelUpGearCraftingLevel {
    public static void levelUpGearCraftingLevel() throws UnsupportedEncodingException {
        UniteState uniteState = GetCharacterInfo.getCharacterInfo();
        System.out.println("gearcraftingLevel: " + uniteState.gearcrafting_level);
        int gearcraftingLevel = uniteState.gearcrafting_level;
        while (gearcraftingLevel < 5) {
            CooperHelmet.cooperHelmet();
            Move.move(5, 1);
            GeSellItem.geSellItem("copper_helmet");
            System.out.println("gearcraftingLevel: " + gearcraftingLevel);
            gearcraftingLevel = uniteState.gearcrafting_level;
        }
        if (gearcraftingLevel == 5) {
            CopperLegsArmor.copperLegsArmor();
            Equip.equip("copper_legs_armor", "leg_armor");
            FeatherCoat.featherCoat();
            Equip.equip("feather_coat", "body_armor");
            CopperArmor.copperArmor();
        }
        System.out.println("gearcraftingLevel: " + uniteState.gearcrafting_level);
        gearcraftingLevel = uniteState.gearcrafting_level;
    }
}

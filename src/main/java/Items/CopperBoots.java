package Items;

import Actions.CollectResourses;
import Actions.Craft;
import Actions.Equip;
import Actions.Move;

import java.io.UnsupportedEncodingException;

public class CopperBoots {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Move.move(2, 0);
        for (int i = 0; i < 64; i++) {
            CollectResourses.gathering();
        }
        Move.move(1, 5);
        for (int i = 0; i < 8; i++) {
            Craft.crafting("copper");
        }
        Move.move(3,1);
        Craft.crafting("copper_boots");
        Equip.equip("copper_boots", "boots");
    }
}

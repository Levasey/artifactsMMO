package Items;

import Actions.CollectResourses;
import Actions.Craft;
import Actions.Equip;
import Actions.Move;

import java.io.UnsupportedEncodingException;

public class WoodenShield {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Move.move(-1, 0);
        for (int i = 0; i < 48; i++) {
            CollectResourses.gathering();
        }
        Move.move(-2, -3);
        for (int i = 0; i < 6; i++) {
            Craft.crafting("ash_plank");
        }
        Move.move(3, 1);
        Craft.crafting("wooden_shield");
        Equip.equip("wooden_shield", "shield");
    }
}


package Items;

import Actions.CollectResourses;
import Actions.Craft;
import Actions.Equip;
import Actions.Move;

import java.io.UnsupportedEncodingException;

public class CopperRing {
    public static void copperRing() throws UnsupportedEncodingException {
        Move.move(2, 0);
        for (int i = 0; i < 48; i++) {
            CollectResourses.gathering();
        }
        Move.move(1, 5);
        for (int i = 0; i < 6; i++) {
            Craft.crafting("copper");
        }
        Move.move(1,3);
        Craft.crafting("copper_ring");
    }
}

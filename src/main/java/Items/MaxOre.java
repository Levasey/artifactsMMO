package Items;

import Actions.CollectResourses;
import Actions.Move;
import pojo.UniteState;

import java.io.UnsupportedEncodingException;

public class MaxOre {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Move.move(2, 0);
        UniteState uniteState = CollectResourses.gathering();
        while (uniteState.inventory_max_items > uniteState.getTotalQuantity()) {
            uniteState = CollectResourses.gathering();
        }
    }
}

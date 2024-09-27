package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class UniteState {
    public int x;
    public int y;
    public int jewelrycrafting_level;
    public int fishing_level;
    public int weaponcrafting_level;
    public int gearcrafting_level;
    public int inventory_max_items;
    public List<InventoryItem> inventory;

    public int getQuantity(String codes) {
        return inventory.stream()
                .filter(item -> item.code.equals(codes))
                .mapToInt(item -> item.quantity).sum();
    }

    public int getTotalQuantity() {
        return inventory.stream()
                .mapToInt(item -> item.quantity)
                .sum();
    }
}

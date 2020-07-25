package me.joe.bundle_me.gui_me.element;

import me.joe.bundle_me.gui_me.gui.GUI;
import me.joe.bundle_me.item_me.items.CustomItem;
import org.bukkit.inventory.ItemStack;

public class Item extends Element {

    private ItemStack item;

    public Item(String id, int x, int y, GUI gui, ItemStack item) {
        super(id, x, y, gui);

        this.item = item;
    }

    public Item(String id, int x, int y, GUI gui, CustomItem item) {
        super(id, x, y, gui);

        this.item = item.getItem();
    }

    public ItemStack getItem() {
        return item;
    }

    public void setItem(ItemStack item) {
        this.item = item;
    }
}

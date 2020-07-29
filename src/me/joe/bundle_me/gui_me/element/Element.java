package me.joe.bundle_me.gui_me.element;

import org.bukkit.inventory.ItemStack;

public class Element {

    private ItemStack item;

    public Element(ItemStack item) {
        this.item = item;
    }

    public ItemStack getItem() {
        return this.item;
    }

    public Element setItem(ItemStack item) {
        this.item = item;
        return this;
    }
}

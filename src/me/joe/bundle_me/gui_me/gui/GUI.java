package me.joe.bundle_me.gui_me.gui;

import me.joe.bundle_me.gui_me.element.Element;
import me.joe.bundle_me.gui_me.element.Item;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

import java.util.*;

public class GUI {

    private InventoryType type;
    private Integer size;
    private Set<Element> elements = new HashSet<>();

    public GUI(InventoryType type) {
        this.type = type;
    }

    public GUI(int size) {
        this.size = size;
    }

    public Inventory getInventory() {
        Inventory inventory = this.type == null ? Bukkit.createInventory(null, this.size) : Bukkit.createInventory(null, this.type);

        this.displayElements(inventory);

        return null;
    }

    private void displayElements(Inventory inventory) {
        for (Element element : this.elements) {
            if (element instanceof Item) {
                this.displayItem((Item) element, inventory);
            }
        }
    }

    private void displayItem(Item item, Inventory inventory) {
        int rawPosition = this.getRawPosition(item.getX(), item.getY());

        inventory.setItem(rawPosition, item.getItem());
    }

    private int getRawPosition(int x, int y) { // going to need to replace this w/ specific inventories
        return (y * 9) + x - 1;
    }

    public GUI addElement(Element element) {
        this.elements.add(element);
        return this;
    }

    public List<Element> getElements() {
        return new ArrayList<>(this.elements);
    }

    public GUI removeElement(Element element) {
        this.elements.remove(element);
        return this;
    }
}
package me.joe.bundle_me.gui_me.gui;

import com.mojang.datafixers.util.Pair;
import me.joe.bundle_me.gui_me.GUIMePlugin;
import me.joe.bundle_me.gui_me.element.Button;
import me.joe.bundle_me.gui_me.element.Element;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;

public class GUIManager {

    private GUIMePlugin plugin;

    private HashMap<Player, GUI> openGUIs = new HashMap<>();

    public GUIManager(GUIMePlugin plugin) {
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(new GUIListener(this), this.plugin);
    }

    public Inventory openGUI(GUI gui, Player player) {
        int size = gui.getSize() * 9;

        Inventory inventory = Bukkit.createInventory(null, size);
        this.displayElements(inventory, gui.getElements());
        this.openGUIs.put(player, gui);
        player.openInventory(inventory);
        return inventory;
    }

    public void closeGUI(Player player) {
        this.openGUIs.remove(player);
    }

    public void inventoryOpened(InventoryOpenEvent event) {
        Player player = (Player) event.getPlayer();

        if (!this.hasGUIOpen(player)) {
            return;
        }

        GUI gui = this.getGUI(player);

        this.openGUIs.put(player, gui);
    }

    public void inventoryClosed(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();

        if (!this.hasGUIOpen(player)) {
            return;
        }

        this.openGUIs.remove(player);
    }

    public void inventoryClicked(InventoryClickEvent event) {
        Player player = (Player) event.getView().getPlayer();

        if (!this.hasGUIOpen(player)) {
            return;
        }

        if (event.getClickedInventory() == event.getView().getBottomInventory()) {
            return;
        }

        GUI gui = this.getGUI(player);

        if (gui.getType() == GUIType.MENU) {
            event.setCancelled(true);
        }

        Element element = this.getElementFromSlot(event.getSlot(), gui);

        if (element instanceof Button) {
            for (String command : ((Button) element).getCommands()) {
                player.chat("/" + command);
            }
        }
    }

    private Element getElementFromSlot(int slot, GUI gui) {
        Pair<Integer, Integer> position = this.getPosition(slot);
        int x = position.getFirst();
        int y = position.getSecond();

        return gui.getElement(x, y);
    }

    public void displayElements(Inventory inventory, HashMap<Integer, HashMap<Integer, Element>> elements) {
        for (Integer y : elements.keySet()) {
            for (Integer x : elements.get(y).keySet()) {
                Element element = elements.get(y).get(x);

                if (element == null) {
                    continue;
                }

                if (element instanceof Button) {
                    this.displayButton(x, y, (Button) element, inventory);
                } else {
                    this.displayElement(x, y, element, inventory);
                }
            }
        }
    }

    public void displayElement(int x, int y, Element element, Inventory inventory) {
        inventory.setItem(this.getRawPosition(x, y), element.getItem());
    }

    public void displayButton(int x, int y, Button button, Inventory inventory) {
        this.displayElement(x, y, button, inventory);
    }

    public int getRawPosition(int x, int y) {
        return (y * 9) + x;
    }

    public Pair<Integer, Integer> getPosition(int rawPosition) {
        int y = rawPosition / 9;
        int x = rawPosition % 9;

        return new Pair<>(x, y);
    }

    public boolean hasGUIOpen(Player player) {
        return this.openGUIs.containsKey(player);
    }

    public GUI getGUI(Player player) {
        if (this.openGUIs.containsKey(player)) {
            return this.openGUIs.get(player);
        }

        return null;
    }

    public HashMap<Player, GUI> getGUIS() {
        return this.openGUIs;
    }
}

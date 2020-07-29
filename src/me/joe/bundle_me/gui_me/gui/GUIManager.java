package me.joe.bundle_me.gui_me.gui;

import com.mojang.datafixers.util.Pair;
import me.joe.bundle_me.gui_me.GUIMePlugin;
import me.joe.bundle_me.gui_me.element.Button;
import me.joe.bundle_me.gui_me.element.Element;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
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

        System.out.println("probs ends here");
        this.displayElements(inventory, gui.getElements());
        System.out.println("i was right");

        this.openGUIs.put(player, gui);

        player.openInventory(inventory);

        return inventory;
    }

    public void closeGUI(Player player) {
        this.openGUIs.remove(player);
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
        return (y * 9) + x - 1;
    }

    public Pair<Integer, Integer> getPosition(int rawPosition) {
        int y = rawPosition / 9;
        int x = (rawPosition % 9) + 1;

        System.out.println(y);
        System.out.println(x);

        Pair<Integer, Integer> pair = new Pair<>(x, y);

        return pair;
    }

    public GUI getGUI(Player player) {
        if (this.openGUIs.containsKey(player)) {
            return this.openGUIs.get(player);
        }

        return null;
    }
}

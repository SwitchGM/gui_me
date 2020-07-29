package me.joe.bundle_me.gui_me.gui;

import com.mojang.datafixers.util.Pair;
import me.joe.bundle_me.gui_me.element.Element;
import me.joe.bundle_me.gui_me.events.GUIClickEvent;
import me.joe.bundle_me.gui_me.events.GUICloseEvent;
import me.joe.bundle_me.gui_me.events.GUIOpenEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

public class GUIListener implements Listener {

    private GUIManager manager;

    public GUIListener(GUIManager manager) {
        this.manager = manager;
    }

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {
        Player player = (Player) event.getPlayer();
        GUI gui = this.manager.getGUI(player);

        if (gui == null) {
            return;
        }

        Bukkit.getPluginManager().callEvent(new GUIOpenEvent(gui, player));
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        GUI gui = this.manager.getGUI(player);

        if (gui == null) {
            return;
        }

        Bukkit.getPluginManager().callEvent(new GUICloseEvent(gui, player));
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getView().getPlayer();
        GUI gui = this.manager.getGUI(player);

        if (gui == null) {
            return;
        }

        Pair<Integer, Integer> position = this.manager.getPosition(event.getSlot());
        int x = position.getFirst();
        int y = position.getSecond();

        Element element = gui.getElement(x, y);

        Bukkit.getPluginManager().callEvent(new GUIClickEvent(element, gui, player, event));
    }
}

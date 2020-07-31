package me.joe.bundle_me.gui_me.gui;

import com.mojang.datafixers.util.Pair;
import me.joe.bundle_me.gui_me.element.Button;
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
        this.manager.inventoryOpened(event);
//        Player player = (Player) event.getPlayer();
//        GUI gui = this.manager.getGUI(player);
//
//        if (gui == null) {
//            return;
//        }
//
//        Bukkit.getPluginManager().callEvent(new GUIOpenEvent(gui, player));
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        this.manager.inventoryClosed(event);
//        Player player = (Player) event.getPlayer();
//        GUI gui = this.manager.getGUI(player);
//
//        if (gui == null) {
//            return;
//        }
//
//        Bukkit.getPluginManager().callEvent(new GUICloseEvent(gui, player));
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        this.manager.inventoryClicked(event);
//        System.out.println("INVENTORY CLICK CALLED");
//        for (Player player : this.manager.getGUIS().keySet()) {
//            System.out.println("CURRENT PLAYERS IN GUI LIST: " + player.getName());
//        }
//
//        Player player = (Player) event.getView().getPlayer();
//        GUI gui = this.manager.getGUI(player);
//
//        if (gui == null) {
//            System.out.println("NO GUI, RETURNING");
//            return;
//        }
//
//        Pair<Integer, Integer> position = this.manager.getPosition(event.getSlot());
//        int x = position.getFirst();
//        int y = position.getSecond();
//
//        Element element = gui.getElement(x, y);
//
//    //        Bukkit.getPluginManager().callEvent(new GUIClickEvent(element, gui, player, event));
//
//    //        GUI gui = event.getGui();
//
//        if (gui.getType() == GUIType.MENU) {
//            event.getClickEvent().setCancelled(true);
//        }
//
//        if (event.getElement() instanceof Button) {
//            for (String command : ((Button) event.getElement()).getCommands()) {
//                event.getPlayer().chat("/" + command);
//            }
//        }
    }
}

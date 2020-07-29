package me.joe.bundle_me.gui_me.events;

import me.joe.bundle_me.gui_me.element.Element;
import me.joe.bundle_me.gui_me.gui.GUI;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GUIClickEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private Element element;
    private GUI gui;
    private Player player;
    private InventoryClickEvent clickEvent;

    public GUIClickEvent(Element element, GUI gui, Player player, InventoryClickEvent clickEvent) {
        this.element = element;
        this.gui = gui;
        this.player = player;
        this.clickEvent = clickEvent;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    public GUI getGui() {
        return gui;
    }

    public Player getPlayer() {
        return player;
    }

    public Element getElement() {
        return element;
    }

    public InventoryClickEvent getClickEvent() {
        return clickEvent;
    }
}
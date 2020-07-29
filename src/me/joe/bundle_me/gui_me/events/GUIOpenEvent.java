package me.joe.bundle_me.gui_me.events;

import me.joe.bundle_me.gui_me.gui.GUI;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class GUIOpenEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private GUI gui;
    private Player player;

    public GUIOpenEvent(GUI gui, Player player) {
        this.gui = gui;
        this.player = player;
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
}
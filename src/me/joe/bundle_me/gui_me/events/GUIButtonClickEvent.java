package me.joe.bundle_me.gui_me.events;

import me.joe.bundle_me.gui_me.element.Button;
import me.joe.bundle_me.gui_me.gui.GUI;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class GUIButtonClickEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private GUI gui;
    private Button button;
    private Player player;

    public GUIButtonClickEvent(GUI gui, Button button, Player player) {
        this.gui = gui;
        this.button = button;
        this.player = player;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}

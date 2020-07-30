package me.joe.bundle_me.gui_me;

import me.joe.bundle_me.gui_me.element.Button;
import me.joe.bundle_me.gui_me.events.GUIClickEvent;
import me.joe.bundle_me.gui_me.events.GUICloseEvent;
import me.joe.bundle_me.gui_me.events.GUIOpenEvent;
import me.joe.bundle_me.gui_me.gui.GUI;
import me.joe.bundle_me.gui_me.gui.GUIManager;
import me.joe.bundle_me.gui_me.gui.GUIType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class GUIMeListener implements Listener {

    private GUIManager manager;

    public GUIMeListener(GUIManager manager) {
        this.manager = manager;
    }

    @EventHandler
    public void onGUIOpen(GUIOpenEvent event) { }

    @EventHandler
    public void onGUIClose(GUICloseEvent event) {
        this.manager.closeGUI(event.getPlayer());
    }

    @EventHandler
    public void onGUIClick(GUIClickEvent event) {
        GUI gui = event.getGui();

        if (gui.getType() == GUIType.MENU) {
            event.getClickEvent().setCancelled(true);
        }

        if (event.getElement() instanceof Button) {
            for (String command : ((Button) event.getElement()).getCommands()) {
                event.getPlayer().chat("/" + command);
            }
        }
    }
}

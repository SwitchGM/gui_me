package me.joe.bundle_me.gui_me.element;

import me.joe.bundle_me.gui_me.gui.GUI;
import me.joe.bundle_me.item_me.items.CustomItem;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Button extends Item {

    private List<String> commands = new ArrayList<>();

    public Button(String id, int x, int y, GUI gui, ItemStack item, List<String> commands) {
        super(id, x, y, gui, item);

        this.commands = commands;
    }

    public Button(String id, int x, int y, GUI gui, CustomItem item, List<String> commands) {
        super(id, x, y, gui, item);

        this.commands = commands;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }
}

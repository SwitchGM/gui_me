package me.joe.bundle_me.gui_me.element;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Button extends Element {

    private List<String> commands;

    public Button(ItemStack item, List<String> commands) {
        super(item);
        this.commands = new ArrayList<>(commands);
    }

    public List<String> getCommands() {
        return this.commands;
    }

    public Element addCommands(List<String> commands) {
        this.commands.addAll(commands);
        return this;
    }

    public Element removeCommand(List<String> commands) {
        this.commands.removeAll(commands);
        return this;
    }
}

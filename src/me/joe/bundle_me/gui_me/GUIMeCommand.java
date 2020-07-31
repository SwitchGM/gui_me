package me.joe.bundle_me.gui_me;

import me.joe.bundle_me.gui_me.element.Button;
import me.joe.bundle_me.gui_me.element.Element;
import me.joe.bundle_me.gui_me.gui.GUI;
import me.joe.bundle_me.gui_me.gui.GUIManager;
import me.joe.bundle_me.gui_me.gui.GUIType;
import me.joe.bundle_me.item_me.items.CustomItem;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;

public class GUIMeCommand implements CommandExecutor {

    private GUIManager manager;

    public GUIMeCommand(GUIManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!commandSender.isOp()) {
            return false;
        }

        GUI gui = new GUI(GUIType.MENU, 2);

        Element element = new Element(new CustomItem(Material.CACTUS).setName("&7HEre's A NEma").setShiny(true).getItem());
        Button button = new Button(new ItemStack(Material.NETHER_STAR), new ArrayList<>(Arrays.asList("say hi", "say hello", "say beep boop")));
        gui.setElement(4, 0, element);
        gui.setElement(5, 0, button);
        this.manager.openGUI(gui, (Player) commandSender);
        return false;
    }
}

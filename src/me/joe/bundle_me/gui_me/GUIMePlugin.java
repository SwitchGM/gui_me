package me.joe.bundle_me.gui_me;

import me.joe.bundle_me.gui_me.gui.GUIManager;
import org.bukkit.plugin.java.JavaPlugin;

public class GUIMePlugin extends JavaPlugin {

    public GUIManager manager;

    @Override
    public void onEnable() {
        this.manager = new GUIManager(this);

        this.getServer().getPluginManager().registerEvents(new GUIMeListener(this.manager), this);

        this.getCommand("guime").setExecutor(new GUIMeCommand(this.manager));
    }
}

package me.pray;

import com.earth2me.essentials.Essentials;
import me.pray.commands.ClearNicksCommand;
import me.pray.events.PlayerJoin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class ClearNicks extends JavaPlugin {

    public static ClearNicks plugin;
    public static Essentials essentials = (Essentials) Bukkit.getPluginManager().getPlugin("Essentials");

    @Override
    public void onEnable() {
        plugin = this;

        if(essentials == null) {
            System.out.println("---------------------------------------------------------------");
            System.out.println("No plugin named: Essentials found, disabling.");
            System.out.println("---------------------------------------------------------------");
            this.setEnabled(false);
        }

        getCommand("clearnicks").setExecutor(new ClearNicksCommand());
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);

        System.out.println("---------------------------------------------------------------");
        System.out.println("ClearNicks started successfully!");
        System.out.println("---------------------------------------------------------------");
    }

    @Override
    public void onDisable() {
        plugin = null;
    }


}

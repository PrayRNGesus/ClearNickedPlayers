package me.pray.commands;

import com.earth2me.essentials.Essentials;
import me.pray.ClearNicks;
import net.ess3.api.IUser;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearNicksCommand implements CommandExecutor {

    Essentials essentials = ClearNicks.essentials;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {
            sender.sendMessage(format("&cNo permission."));
            return false;
        }

        int i = 0;

        for (Player p : Bukkit.getOnlinePlayers()) {
            IUser user = essentials.getUser(p.getUniqueId());
            if (user.getFormattedNickname() != null) {
                if (!p.hasPermission("essentials.nick")) {
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "nick " + user.getName() + " off");
                    i++;
                    continue;
                }

                if (!ChatColor.stripColor(user.getFormattedNickname()).equals(user.getName())) {
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "nick " + user.getName() + " off");
                    i++;
                }
            }
        }

        System.out.println("Removed the nicknames of: " + i + " online players!");

        return false;
    }

    private String format(String text) {
        return text.replace("&", "§");
    }

}

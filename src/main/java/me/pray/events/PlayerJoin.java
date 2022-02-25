package me.pray.events;

import com.earth2me.essentials.Essentials;
import me.pray.ClearNicks;
import net.ess3.api.IUser;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    Essentials essentials = ClearNicks.essentials;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        IUser user = essentials.getUser(player.getUniqueId());
        if (user.getFormattedNickname() != null) {
            if (!player.hasPermission("essentials.nick")) {
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "nick " + user.getName() + " off");
            }
        }
    }
}

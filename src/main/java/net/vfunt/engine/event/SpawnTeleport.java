package net.vfunt.engine.event;


import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class SpawnTeleport implements Listener {

    @EventHandler
    public void onPlayerMovedToBelowZero(PlayerMoveEvent event) {
        Location from = event.getFrom();
        Location to = event.getTo();

        assert to != null;
        if (event.getPlayer().getLocation().getY() <= Double.parseDouble("-10.0")) {

        }

    }
}

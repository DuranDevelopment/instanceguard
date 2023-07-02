package cc.ddev.instanceguard.listener.player;

import cc.ddev.instanceguard.InstanceGuard;
import cc.ddev.instanceguard.flag.DefaultFlag;
import cc.ddev.instanceguard.listener.handler.Listen;
import cc.ddev.instanceguard.listener.handler.Listener;
import cc.ddev.instanceguard.logger.Log;
import cc.ddev.instanceguard.region.Region;
import cc.ddev.instanceguard.region.RegionManager;
import cc.ddev.instanceguard.world.WorldManager;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.entity.Player;
import net.minestom.server.event.player.PlayerBlockPlaceEvent;

public class PlayerBlockPlaceListener implements Listener {

    private final InstanceGuard instanceGuard;
    public PlayerBlockPlaceListener(InstanceGuard instanceGuard) {
        this.instanceGuard = instanceGuard;
    }
    @Listen
    public void onPlayerBlockPlace(PlayerBlockPlaceEvent event) {
        Player player = event.getPlayer();

        instanceGuard.getRegionManager().getRegion(player.getPosition());

        if (player.getInstance() == null) return;

        for (Region region : instanceGuard.getRegionManager().getRegions()) {
            if (region.containsLocation(new Pos(event.getBlockPosition()))) {
                Log.getLogger().info("Player " + player.getUsername() + " placed a block in region " + region.getName() + "!");
                if (!region.hasFlag(DefaultFlag.BUILD)) {
                    if (!region.isOwner(player) || !region.isMember(player)) {
                        event.setCancelled(true);
                    }
                }
            }
        }
    }
}

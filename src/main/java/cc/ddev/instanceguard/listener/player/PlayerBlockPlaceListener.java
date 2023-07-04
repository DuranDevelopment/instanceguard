package cc.ddev.instanceguard.listener.player;

import cc.ddev.instanceguard.InstanceGuard;
import cc.ddev.instanceguard.flag.DefaultFlag;
import cc.ddev.instanceguard.flag.FlagValue;
import cc.ddev.instanceguard.listener.handler.Listen;
import cc.ddev.instanceguard.listener.handler.Listener;
import cc.ddev.instanceguard.region.Region;
import cc.ddev.instanceguard.utils.ChatUtils;
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
        if (player.getInstance() == null) return;

        for (Region region : instanceGuard.getRegionManager().getRegions()) {
            if (region.containsLocation(new Pos(event.getBlockPosition()))) {
                FlagValue<?> buildFlagValue = region.getFlagValue(DefaultFlag.BUILD.getName());
                FlagValue<?> buildGroup = region.getFlagValue(DefaultFlag.BUILD_GROUP.getName());

                if (buildFlagValue.getValue().equals("allow")) {
                    if (buildGroup.getValue().equals("MEMBERS")) {
                        if (!region.isMember(player)) {
                            cancelEvent(event, player);
                            return;
                        }
                    } else if (buildGroup.getValue().equals("NON_MEMBERS")) {
                        if (region.isMember(player)) {
                            cancelEvent(event, player);
                            return;
                        }
                    }
                } else if (buildFlagValue.getValue().equals("deny")) {
                    if (buildGroup.getValue().equals("MEMBERS")) {
                        if (!region.isMember(player)) {
                            cancelEvent(event, player);
                            return;
                        }
                    } else if (buildGroup.getValue().equals("NON_MEMBERS")) {
                        if (region.isMember(player)) {
                            cancelEvent(event, player);
                            return;
                        }
                    }
                    cancelEvent(event, player);
                    return;
                }
            }
        }
    }

    private void cancelEvent(PlayerBlockPlaceEvent event, Player player) {
        event.setCancelled(true);
        player.sendMessage(ChatUtils.translateMiniMessage("<red>You cannot build here!"));
    }
}

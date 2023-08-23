package cc.ddev.instanceguard;

import cc.ddev.instanceguard.flag.FlagManager;
import cc.ddev.instanceguard.listener.player.PlayerBlockPlaceListener;
import cc.ddev.instanceguard.logger.Log;
import cc.ddev.instanceguard.region.RegionManager;
import net.minestom.server.event.Event;
import net.minestom.server.event.EventNode;

import java.util.ArrayList;

public class InstanceGuard {
    RegionManager regionManager = new RegionManager();
    FlagManager flagManager = new FlagManager();
    ArrayList<EventNode<?>> events = new ArrayList<>();

    public InstanceGuard() {
        Log.getLogger().info("InstanceGuard initiated...");
        events.add(new PlayerBlockPlaceListener(this).register());
        // Register default flags
        flagManager.registerCustomFlag("build", "allow");
        flagManager.registerCustomFlag("build_group", "MEMBERS");
        flagManager.registerCustomFlag("block_break", "allow");
        flagManager.registerCustomFlag("block_break_group", "MEMBERS");
        flagManager.registerCustomFlag("block_place", "allow");
        flagManager.registerCustomFlag("block_place_group", "MEMBERS");
        flagManager.registerCustomFlag("interact", "allow");
        flagManager.registerCustomFlag("interact_group", "MEMBERS");
        flagManager.registerCustomFlag("use", "allow");
        flagManager.registerCustomFlag("use_group", "MEMBERS");
        flagManager.registerCustomFlag("chest_access", "allow");
        flagManager.registerCustomFlag("chest_access_group", "MEMBERS");
        flagManager.registerCustomFlag("pvp", "allow");
        flagManager.registerCustomFlag("pvp_group", "MEMBERS");
    }
    public void enable(EventNode<Event> root) {
        for (var n : events) root.addChild(n);
    }
    public RegionManager getRegionManager() {
        return regionManager;
    }

    public FlagManager getFlagManager() {
        return flagManager;
    }
}

package cc.ddev.instanceguard;

import cc.ddev.instanceguard.flag.DefaultFlagValue;
import cc.ddev.instanceguard.flag.FlagManager;
import cc.ddev.instanceguard.listener.player.PlayerBlockPlaceListener;
import cc.ddev.instanceguard.logger.Log;
import cc.ddev.instanceguard.region.RegionManager;
import net.minestom.server.event.Event;
import net.minestom.server.event.EventNode;

import java.util.ArrayList;

public class InstanceGuard {

    public static InstanceGuard instance = new InstanceGuard();
    RegionManager regionManager = new RegionManager();
    FlagManager flagManager = new FlagManager();
    ArrayList<EventNode<?>> events = new ArrayList<>();

    public InstanceGuard() {
        Log.getLogger().info("InstanceGuard initiated...");
        events.add(new PlayerBlockPlaceListener(this).register());
        // Register default flags
        flagManager.registerCustomFlag("build", DefaultFlagValue.ALLOW.getValue());
        flagManager.registerCustomFlag("build_group", DefaultFlagValue.MEMBERS.getValue());
        flagManager.registerCustomFlag("block_break", DefaultFlagValue.ALLOW.getValue());
        flagManager.registerCustomFlag("block_break_group", DefaultFlagValue.MEMBERS.getValue());
        flagManager.registerCustomFlag("block_place", DefaultFlagValue.ALLOW.getValue());
        flagManager.registerCustomFlag("block_place_group", DefaultFlagValue.MEMBERS.getValue());
        flagManager.registerCustomFlag("interact", DefaultFlagValue.ALLOW.getValue());
        flagManager.registerCustomFlag("interact_group", DefaultFlagValue.MEMBERS.getValue());
        flagManager.registerCustomFlag("use", DefaultFlagValue.ALLOW.getValue());
        flagManager.registerCustomFlag("use_group", DefaultFlagValue.MEMBERS.getValue());
        flagManager.registerCustomFlag("chest_access", DefaultFlagValue.ALLOW.getValue());
        flagManager.registerCustomFlag("chest_access_group", DefaultFlagValue.MEMBERS.getValue());
        flagManager.registerCustomFlag("pvp", DefaultFlagValue.ALLOW.getValue());
        flagManager.registerCustomFlag("pvp_group", DefaultFlagValue.MEMBERS.getValue());
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

    public static InstanceGuard getInstance() {
        return instance;
    }
}

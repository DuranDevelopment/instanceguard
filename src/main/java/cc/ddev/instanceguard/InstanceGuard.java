package cc.ddev.instanceguard;

import cc.ddev.instanceguard.flag.FlagManager;
import cc.ddev.instanceguard.listener.player.PlayerBlockPlaceListener;
import cc.ddev.instanceguard.logger.Log;
import cc.ddev.instanceguard.region.RegionManager;

public class InstanceGuard {
    RegionManager regionManager = new RegionManager();
    FlagManager flagManager = new FlagManager();

    public InstanceGuard() {
        Log.getLogger().info("InstanceGuard initiated...");
        new PlayerBlockPlaceListener(this).register();
        // Register default flags
        flagManager.registerCustomFlag("build", "allow");
        flagManager.registerCustomFlag("build_group", "members");
        flagManager.registerCustomFlag("block_break", "allow");
        flagManager.registerCustomFlag("block_break_group", "members");
        flagManager.registerCustomFlag("block_place", "allow");
        flagManager.registerCustomFlag("block_place_group", "members");
        flagManager.registerCustomFlag("interact", "allow");
        flagManager.registerCustomFlag("interact_group", "members");
        flagManager.registerCustomFlag("use", "allow");
        flagManager.registerCustomFlag("use_group", "members");
    }
    public RegionManager getRegionManager() {
        return regionManager;
    }

    public FlagManager getFlagManager() {
        return flagManager;
    }
}

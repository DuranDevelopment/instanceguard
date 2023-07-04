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
    public RegionManager getRegionManager() {
        return regionManager;
    }

    public FlagManager getFlagManager() {
        return flagManager;
    }
}

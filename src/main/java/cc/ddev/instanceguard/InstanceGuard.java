package cc.ddev.instanceguard;

import cc.ddev.instanceguard.logger.Log;
import cc.ddev.instanceguard.managers.RegionManager;

public class InstanceGuard {
    RegionManager regionManager = new RegionManager();
    public static void main(String[] args) {
        Log.getLogger().debug("InstanceGuard initiated...");
    }

    public RegionManager getRegionManager() {
        return regionManager;
    }
}

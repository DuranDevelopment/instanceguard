package cc.ddev.instanceguard;

import cc.ddev.instanceguard.listener.player.PlayerBlockPlaceListener;
import cc.ddev.instanceguard.logger.Log;
import cc.ddev.instanceguard.region.RegionManager;

public class InstanceGuard {
    RegionManager regionManager = new RegionManager();
//    public static void main(String[] args) {
//        System.out.println("InstanceGuard initiated...");
//        new PlayerBlockPlaceListener().register();
//    }

    public InstanceGuard() {
        Log.getLogger().info("InstanceGuard initiated...");
        new PlayerBlockPlaceListener(this).register();
    }
    public RegionManager getRegionManager() {
        return regionManager;
    }
}

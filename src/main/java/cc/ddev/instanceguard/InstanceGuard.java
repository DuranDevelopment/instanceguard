package cc.ddev.instanceguard;

import cc.ddev.instanceguard.objects.Region;
import net.minestom.server.coordinate.Pos;

import java.util.HashMap;
import java.util.Map;

public class InstanceGuard {
    private final Map<String, Region> regions;

    public InstanceGuard() {
        regions = new HashMap<>();
    }

    public void getRegions(String worldName) {
        regions.get(worldName);
    }

    public void createRegion(String worldName, Pos minLocation, Pos maxLocation) {
        regions.put(worldName, new Region(minLocation, maxLocation));
    }

    public void removeRegion(String worldName) {
        regions.remove(worldName);
    }
}

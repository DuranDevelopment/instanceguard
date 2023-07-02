package cc.ddev.instanceguard.managers;

import cc.ddev.instanceguard.objects.Region;
import net.minestom.server.coordinate.Pos;

import java.util.HashMap;
import java.util.Map;

public class RegionManager {

    private final Map<String, Region> regions = new HashMap<>();

    public Region getRegions(String instanceName) {
        return regions.get(instanceName);
    }

    public Region getRegion(Region region) {
        return region;
    }

    public void createRegion(String regionName, String instanceName, Pos minLocation, Pos maxLocation) {
        regions.put(instanceName, new Region(regionName, minLocation, maxLocation));
    }

    public void removeRegion(String regionName) {
        regions.remove(regionName);
    }
}

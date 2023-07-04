package cc.ddev.instanceguard.region;

import cc.ddev.instanceguard.flag.FlagValue;
import net.minestom.server.coordinate.Pos;

import java.util.ArrayList;
import java.util.List;

public class RegionManager {

    private final List<Region> regions = new ArrayList<>();

    public List<Region> getRegions() {
        return regions;
    }

    public Region getRegion(Region region) {
        return region;
    }

    public Region getRegion(String regionName, String instanceName) {
        for (Region region : regions) {
            if (region.getName().equals(regionName) && region.getInstanceName().equals(instanceName)) {
                return region;
            }
        }

        return null;
    }

    public Region getRegion(Pos location) {
        for (Region region : regions) {
            if (region.containsLocation(location)) {
                return region;
            }
        }

        return null;
    }

    public void createRegion(String regionName, String instanceName, Pos minLocation, Pos maxLocation) {
        regions.add(new Region(regionName, instanceName, minLocation, maxLocation));
    }

    public void removeRegion(Region region) {
        regions.remove(region);
    }

    public void setFlag(String regionName, String instanceName, String flag, FlagValue<?> value) {
        Region region = getRegion(regionName, instanceName);
        if (region != null) {
            region.setFlag(flag, value);
        }
    }
}

package cc.ddev.instanceguard.region;

import cc.ddev.instanceguard.flag.DefaultFlag;
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

    public Region getRegion(String regionName) {
        for (Region region : regions) {
            if (region.getName().equals(regionName)) {
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

    public void setFlag(String regionName, DefaultFlag flag, boolean value) {
        Region region = getRegion(regionName);
        if (region != null) {
            region.setFlag(flag, value);
        }
    }
}

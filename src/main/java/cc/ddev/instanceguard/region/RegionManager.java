package cc.ddev.instanceguard.region;

import cc.ddev.instanceguard.flag.FlagValue;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.instance.Instance;

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

    public Region getRegion(String regionName, Instance instance) {
        for (Region region : regions) {
            if (region.getName().equals(regionName) && region.getInstance() == instance) {
                return region;
            }
        }

        return null;
    }

    public Region getRegion(Pos location, Instance instance) {
        for (Region region : regions) {
            if (region.containsLocation(location) && region.getInstance() == instance) {
                return region;
            }
        }

        return null;
    }

    public void createRegion(String regionName, Instance instance, Pos minLocation, Pos maxLocation) {
        regions.add(new Region(regionName, instance, minLocation, maxLocation));
    }

    public void removeRegion(Region region) {
        regions.remove(region);
    }

    public void setFlag(Region region, Instance instance, String flag, FlagValue<?> value) {
        region.setFlag(flag, value);
    }

    public void setFlag(String regionName, Instance instance, String flag, FlagValue<?> value) {
        Region region = getRegion(regionName, instance);
        if (region != null) {
            region.setFlag(flag, value);
        }
    }
}

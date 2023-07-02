package cc.ddev.instanceguard.objects;

import net.minestom.server.coordinate.Pos;

public class Region {
    private final String name;
    private final Pos minLocation;
    private final Pos maxLocation;

    public Region(String name, Pos minLocation, Pos maxLocation) {
        this.name = name;
        this.minLocation = minLocation;
        this.maxLocation = maxLocation;
    }

    public boolean containsLocation(Pos location) {
        return location.x() >= minLocation.x() && location.x() <= maxLocation.x()
                && location.y() >= minLocation.y() && location.y() <= maxLocation.y()
                && location.z() >= minLocation.z() && location.z() <= maxLocation.z();
    }

    public String getName() {
        return name;
    }

    public Pos getMinLocation() {
        return minLocation;
    }

    public Pos getMaxLocation() {
        return maxLocation;
    }
}
package cc.ddev.instanceguard.objects;

import net.minestom.server.coordinate.Pos;

public class Region {
    private final Pos minLocation;
    private final Pos maxLocation;

    public Region(Pos minLocation, Pos maxLocation) {
        this.minLocation = minLocation;
        this.maxLocation = maxLocation;
    }

    public boolean containsLocation(Pos location) {
        return location.x() >= minLocation.x() && location.x() <= maxLocation.x()
                && location.y() >= minLocation.y() && location.y() <= maxLocation.y()
                && location.z() >= minLocation.z() && location.z() <= maxLocation.z();
    }
}
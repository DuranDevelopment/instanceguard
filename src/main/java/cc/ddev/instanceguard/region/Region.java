package cc.ddev.instanceguard.region;

import cc.ddev.instanceguard.flag.DefaultFlag;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.entity.Player;
import net.minestom.server.instance.Instance;

import java.util.*;

public class Region {
    private final String name;
    private final String instanceName;
    private final Pos minLocation;
    private final Pos maxLocation;
    private final Map<DefaultFlag, Boolean> flags;
    private final List<UUID> owners;
    private final List<UUID> members;

    public Region(String name, String instanceName, Pos minLocation, Pos maxLocation) {
        this.name = name;
        this.minLocation = minLocation;
        this.maxLocation = maxLocation;
        this.flags = new HashMap<>();
        this.members = new ArrayList<>();
        this.owners = new ArrayList<>();
        this.instanceName = instanceName;
    }

    public boolean containsLocation(Pos location) {
        return location.x() >= minLocation.x() && location.x() <= maxLocation.x()
                && location.y() >= minLocation.y() && location.y() <= maxLocation.y()
                && location.z() >= minLocation.z() && location.z() <= maxLocation.z();
    }

    public void setFlag(DefaultFlag flag, boolean value) {
        flags.put(flag, value);
    }

    public boolean hasFlag(DefaultFlag flag) {
        return flags.containsKey(flag) && flags.get(flag);
    }

    public void addOwner(Player player) {
        owners.add(player.getUuid());
    }

    public void removeOwner(Player player) {
        owners.remove(player.getUuid());
    }

    public boolean isOwner(Player player) {
        return owners.contains(player.getUuid());
    }

    public void addMember(Player player) {
        members.add(player.getUuid());
    }

    public void removeMember(Player player) {
        members.remove(player.getUuid());
    }

    public boolean isMember(Player player) {
        return members.contains(player.getUuid());
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
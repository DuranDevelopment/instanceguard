package cc.ddev.instanceguard.region;

import cc.ddev.instanceguard.flag.DefaultFlag;
import cc.ddev.instanceguard.flag.FlagValue;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.entity.Player;
import net.minestom.server.instance.Instance;

import java.util.*;

public class Region {
    private final String name;
    private final String instanceName;
    private final Pos minLocation;
    private final Pos maxLocation;
    private final Map<DefaultFlag, FlagValue> flags;
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

        // Check if the player's X coordinate is between location1 and location2
        boolean isXBetween = (location.x() >= Math.min(maxLocation.x(), minLocation.x()))
                && (location.x() <= Math.max(maxLocation.x(), minLocation.x()));

        // Check if the player's Y coordinate is between location1 and location2
        boolean isYBetween = (location.y() >= Math.min(maxLocation.y(), minLocation.y()))
                && (location.y() <= Math.max(maxLocation.y(), minLocation.y()));

        // Check if the player's Z coordinate is between location1 and location2
        boolean isZBetween = (location.z() >= Math.min(maxLocation.z(), minLocation.z()))
                && (location.z() <= Math.max(maxLocation.z(), minLocation.z()));

        // Return true if the player is between both locations in all three axes
        return isXBetween && isYBetween && isZBetween;
    }

    public void setFlag(DefaultFlag flag, FlagValue value) {
        flags.put(flag, value);
    }

    public boolean hasFlag(DefaultFlag flag) {
        return flags.containsKey(flag);
    }
    public FlagValue getFlagValue(DefaultFlag flag) {
        return flags.get(flag);
    }

    public void addOwner(Player player) {
        owners.add(player.getUuid());
    }

    public void removeOwner(Player player) {
        owners.remove(player.getUuid());
    }

    public List<UUID> getOwners() {
        return owners;
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

    public List<UUID> getMembers() {
        return members;
    }

    public boolean isMember(Player player) {
        return members.contains(player.getUuid());
    }

    public String getName() {
        return name;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public Pos getMinLocation() {
        return minLocation;
    }

    public Pos getMaxLocation() {
        return maxLocation;
    }
}
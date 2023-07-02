package cc.ddev.instanceguard.world;

import net.minestom.server.instance.Instance;
import net.minestom.server.tag.Tag;

public class WorldManager {

    public static String getInstanceName(Instance instance) {
        String name = instance.getTag(Tag.String("name"));
        if (name == null) {
            name = instance.getUniqueId().toString();
        }
        return name;
    }
}

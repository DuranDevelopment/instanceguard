package cc.ddev.instanceguard.flag;

public enum DefaultFlag {
    BUILD("build"),
    BUILD_GROUP("build_group"),
    INTERACT("interact"),
    INTERACT_GROUP("interact_group"),
    USE("use"),
    USE_GROUP("use_group"),
    BLOCK_BREAK("block_break"),
    BLOCK_BREAK_GROUP("block_break_group"),
    BLOCK_PLACE("block_place"),
    BLOCK_PLACE_GROUP("block_place_group"),
    CHEST_ACCESS("chest_access"),
    CHEST_ACCESS_GROUP("chest_access_group"),
    PVP("pvp"),
    PVP_GROUP("pvp_group");

    private final String name;

    DefaultFlag(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

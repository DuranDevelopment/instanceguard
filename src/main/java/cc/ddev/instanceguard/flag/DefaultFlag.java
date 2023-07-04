package cc.ddev.instanceguard.flag;

public enum DefaultFlag {
    BUILD("build"),
    BUILD_GROUP("build-group"),
    INTERACT("interact"),
    INTERACT_GROUP("interact-group"),
    USE("use"),
    USE_GROUP("use-group"),
    BLOCK_BREAK("block_break"),
    BLOCK_BREAK_GROUP("block_break-group"),
    BLOCK_PLACE("block_place"),
    BLOCK_PLACE_GROUP("block_place-group");

    private final String name;

    DefaultFlag(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

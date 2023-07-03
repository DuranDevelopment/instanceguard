package cc.ddev.instanceguard.flag;

public enum DefaultFlag {
    BUILD("build"),
    BUILD_GROUP("build-group"),
    INTERACT("interact"),
    USE("use"),
    BLOCK_BREAK("block_break"),
    BLOCK_PLACE("block_place");

    private final String name;

    DefaultFlag(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

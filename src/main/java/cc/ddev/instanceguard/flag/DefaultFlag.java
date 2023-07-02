package cc.ddev.instanceguard.flag;

public enum DefaultFlag {
    BUILD("Build", true),
    INTERACT("Interact", true),
    PVP("PvP", false);

    private final String name;
    private final boolean defaultValue;

    DefaultFlag(String name, boolean defaultValue) {
        this.name = name;
        this.defaultValue = defaultValue;
    }

    public String getName() {
        return name;
    }

    public boolean getDefaultValue() {
        return defaultValue;
    }
}
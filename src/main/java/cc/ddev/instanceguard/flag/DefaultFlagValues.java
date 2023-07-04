package cc.ddev.instanceguard.flag;

public enum DefaultFlagValues {
    NON_MEMBERS("NON_MEMBERS"),
    MEMBERS("MEMBERS"),
    OWNERS("OWNERS"),
    ALLOW("allow"),
    DENY("deny");

    private final String name;

    DefaultFlagValues(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

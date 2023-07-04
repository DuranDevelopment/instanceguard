package cc.ddev.instanceguard.flag;

public enum DefaultFlagValue {
    NON_MEMBERS(new FlagValue<>("NON_MEMBERS")),
    MEMBERS(new FlagValue<>("MEMBERS")),
    OWNERS(new FlagValue<>("OWNERS")),
    ALLOW(new FlagValue<>("allow")),
    DENY(new FlagValue<>("deny"));


    private final FlagValue<?> value;

    DefaultFlagValue(FlagValue<?> value) {
        this.value = value;
    }

    public FlagValue<?> getValue() {
        return value;
    }
}

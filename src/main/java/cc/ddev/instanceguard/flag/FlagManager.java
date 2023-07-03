package cc.ddev.instanceguard.flag;

import java.util.HashMap;
import java.util.Map;

public class FlagManager {
    private final Map<String, FlagValue<?>> customFlags = new HashMap<>();

    public <T> void registerCustomFlag(String flagName, T defaultValue) {
        customFlags.put(flagName, new FlagValue<>(defaultValue));
    }

    public <T> void setCustomFlagValue(String flagName, T value) {
        if (customFlags.containsKey(flagName)) {
            FlagValue<T> flagValue = (FlagValue<T>) customFlags.get(flagName);
            flagValue.setValue(value);
        }
    }
}

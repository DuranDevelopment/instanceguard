package cc.ddev.instanceguard.flag;

public class FlagValue<T> {
    private T value;

    public FlagValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
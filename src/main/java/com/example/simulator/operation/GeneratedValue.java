package com.example.simulator.operation;

public final class GeneratedValue {

    private final String value;

    public GeneratedValue(String value) {
        Preconditions.checkNotNull(value, "Value cannot be null");
        this.value = value;
    }

    public GeneratedValue(Integer value) {
        Preconditions.checkNotNull(value, "Value cannot be null");
        this.value = String.valueOf(value);
    }

    public Integer asNumber() {
        if (this.value.matches("-?\\d+")) {
            return Integer.valueOf(this.value);
        }
        throw new OperationException("Cannot convert value " + this.value + " to number");
    }

    public String asString() {
        return this.value;
    }
}

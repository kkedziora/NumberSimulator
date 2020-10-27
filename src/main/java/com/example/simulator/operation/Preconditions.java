package com.example.simulator.operation;

public class Preconditions {

    public static <T> void checkNotNull(T reference, String errorMessageArgs) {
        if (reference == null) {
            throw new IllegalArgumentException(errorMessageArgs);
        }
    }
}

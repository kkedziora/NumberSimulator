package com.example.simulator.operation;

import java.util.List;

public interface Computation<T> {

    T calculate(List<T> values);

    OperationType getType();
}

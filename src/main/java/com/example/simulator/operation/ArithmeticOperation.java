package com.example.simulator.operation;

import java.util.List;

public interface ArithmeticOperation<T extends Number> {

    T calculate(List<T> values);
}

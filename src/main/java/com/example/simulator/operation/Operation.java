package com.example.simulator.operation;

public interface Operation<T> {

    T getResult(CalculationParams calculationParams);
}

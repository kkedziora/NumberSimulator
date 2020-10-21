package com.example.simulator.operation;

public interface Operation<T> {

    T getResult(OperationType operationType);
}

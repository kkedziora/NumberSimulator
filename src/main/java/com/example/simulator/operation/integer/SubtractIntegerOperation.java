package com.example.simulator.operation.integer;

import com.example.simulator.operation.ArithmeticOperation;
import com.example.simulator.operation.OperationException;

import java.util.List;

class SubtractIntegerOperation implements ArithmeticOperation<Integer> {

    @Override
    public Integer calculate(List<Integer> values) {
        return values.stream()
                .reduce((left, right) -> left - right)
                .orElseThrow(() -> new OperationException("Cannot subtract values"));
    }
}

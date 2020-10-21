package com.example.simulator.operation.integer;

import com.example.simulator.operation.ArithmeticOperation;
import com.example.simulator.operation.OperationException;

import java.util.List;

class AddIntegerOperation implements ArithmeticOperation<Integer> {

    @Override
    public Integer calculate(List<Integer> values) {
        return values.stream()
                .reduce(Integer::sum)
                .orElseThrow(() -> new OperationException("Cannot add values"));
    }
}

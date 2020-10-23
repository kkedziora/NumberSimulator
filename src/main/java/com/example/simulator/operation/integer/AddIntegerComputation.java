package com.example.simulator.operation.integer;

import com.example.simulator.operation.ArithmeticComputation;
import com.example.simulator.operation.OperationException;
import com.example.simulator.operation.OperationType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class AddIntegerComputation implements ArithmeticComputation<Integer> {

    @Override
    public Integer calculate(List<Integer> values) {
        return values.stream()
                .reduce(Integer::sum)
                .orElseThrow(() -> new OperationException("Cannot add values"));
    }

    @Override
    public OperationType getType() {
        return OperationType.ADDITION;
    }
}

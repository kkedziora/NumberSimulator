package com.example.simulator.operation.computation;

import com.example.simulator.operation.GeneratedValue;
import com.example.simulator.operation.OperationException;
import com.example.simulator.operation.OperationType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class SubtractComputation implements Computation {

    @Override
    public GeneratedValue calculate(List<GeneratedValue> values) {
        return values.stream()
                .map(GeneratedValue::asNumber)
                .reduce((left, right) -> left - right)
                .map(GeneratedValue::new)
                .orElseThrow(() -> new OperationException("Cannot subtract values"));
    }

    @Override
    public OperationType getType() {
        return OperationType.SUBTRACTION;
    }
}

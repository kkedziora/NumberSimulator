package com.example.simulator.operation.computation;

import com.example.simulator.operation.GeneratedValue;
import com.example.simulator.operation.OperationException;
import com.example.simulator.operation.OperationType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class AddComputation implements Computation {

    @Override
    public GeneratedValue calculate(List<GeneratedValue> values) {
        return values.stream()
                .map(GeneratedValue::asNumber)
                .reduce(Integer::sum)
                .map(GeneratedValue::new)
                .orElseThrow(() -> new OperationException("Cannot add values"));
    }

    @Override
    public OperationType getType() {
        return OperationType.ADDITION;
    }
}

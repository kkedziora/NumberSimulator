package com.example.simulator.operation.integer;

import com.example.simulator.operation.ArithmeticComputation;
import com.example.simulator.operation.OperationException;
import com.example.simulator.operation.OperationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IntegerOperationFactory {

    private final List<ArithmeticComputation<Integer>> operations;

    @Autowired
    public IntegerOperationFactory(List<ArithmeticComputation<Integer>> operations) {
        this.operations = operations;
    }

    public ArithmeticComputation<Integer> getCalculationFor(OperationType operationType) {
        return operations.stream()
                .filter(integerOperation -> integerOperation.getType().equals(operationType))
                .findFirst()
                .orElseThrow(() -> new OperationException("Operation not supported " + operationType));
    }
}

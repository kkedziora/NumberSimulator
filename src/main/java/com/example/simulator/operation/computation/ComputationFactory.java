package com.example.simulator.operation.computation;

import com.example.simulator.operation.OperationException;
import com.example.simulator.operation.OperationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ComputationFactory {

    private final List<Computation> operations;

    @Autowired
    public ComputationFactory(List<Computation> operations) {
        this.operations = operations;
    }

    public Computation getComputation(OperationType operationType) {
        return operations.stream()
                .filter(operation -> operation.getType().equals(operationType))
                .findFirst()
                .orElseThrow(() -> new OperationException("Operation not supported " + operationType));
    }
}

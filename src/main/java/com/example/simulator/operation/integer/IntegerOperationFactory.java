package com.example.simulator.operation.integer;

import com.example.simulator.operation.ArithmeticOperation;
import com.example.simulator.operation.OperationException;
import com.example.simulator.operation.OperationType;

import java.util.EnumMap;
import java.util.Map;

public class IntegerOperationFactory {

    private static final Map<OperationType, ArithmeticOperation<Integer>> operationMap = new EnumMap<>(OperationType.class);

    static {
        operationMap.put(OperationType.ADDITION, new AddIntegerOperation());
        operationMap.put(OperationType.SUBTRACTION, new SubtractIntegerOperation());
    }

    public static ArithmeticOperation<Integer> getCalculationFor(OperationType operationType) {
        ArithmeticOperation<Integer> arithmeticOperation = operationMap.get(operationType);
        if (arithmeticOperation != null) {
            return arithmeticOperation;
        }
        throw new OperationException("Operation not supported " + operationType);
    }
}

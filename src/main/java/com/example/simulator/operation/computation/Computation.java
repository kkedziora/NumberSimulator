package com.example.simulator.operation.computation;

import com.example.simulator.operation.GeneratedValue;
import com.example.simulator.operation.OperationType;

import java.util.List;

public interface Computation {

    GeneratedValue calculate(List<GeneratedValue> values);

    OperationType getType();
}

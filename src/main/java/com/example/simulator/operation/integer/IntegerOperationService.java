package com.example.simulator.operation.integer;

import com.example.simulator.operation.Operation;
import com.example.simulator.operation.OperationType;
import com.example.simulator.source.number.NumberSource;
import com.example.simulator.source.number.integer.IntegerSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class IntegerOperationService implements Operation<Integer> {

    private final List<IntegerSource> integerSources;

    @Autowired
    public IntegerOperationService(List<IntegerSource> integerSources) {
        this.integerSources = integerSources;
    }

    @Override
    public Integer getResult(OperationType operationType) {
        List<Integer> values = integerSources.stream()
                .map(NumberSource::getNumber)
                .collect(Collectors.toList());

        return IntegerOperationFactory.getCalculationFor(operationType)
                .calculate(values);
    }
}

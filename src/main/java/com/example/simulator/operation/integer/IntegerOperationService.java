package com.example.simulator.operation.integer;

import com.example.simulator.operation.CalculationParams;
import com.example.simulator.operation.Operation;
import com.example.simulator.source.number.NumberSource;
import com.example.simulator.source.number.integer.IntegerSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class IntegerOperationService implements Operation<Integer> {

    private final List<IntegerSource> integerSources;
    private final IntegerOperationFactory integerOperationFactory;

    @Autowired
    public IntegerOperationService(List<IntegerSource> integerSources, IntegerOperationFactory integerOperationFactory) {
        this.integerSources = integerSources;
        this.integerOperationFactory = integerOperationFactory;
    }

    @Override
    public Integer getResult(CalculationParams calculationParams) {
        List<Integer> values = integerSources.stream()
                .filter(integerSource -> calculationParams.getAllowedSources().contains(integerSource.getSource()))
                .map(NumberSource::getValue)
                .collect(Collectors.toList());

        return integerOperationFactory.getCalculationFor(calculationParams.getOperationType())
                .calculate(values);
    }
}

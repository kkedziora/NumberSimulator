package com.example.simulator.operation;

import com.example.simulator.operation.computation.ComputationFactory;
import com.example.simulator.source.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OperationService implements Operation {

    private final List<Source> sources;
    private final ComputationFactory computationFactory;

    @Autowired
    public OperationService(List<Source> sources, ComputationFactory computationFactory) {
        this.sources = sources;
        this.computationFactory = computationFactory;
    }

    @Override
    public GeneratedValue getResult(ComputationParams computationParams) {
        List<GeneratedValue> values = sources.stream()
                .filter(source -> computationParams.getAllowedSources().contains(source.getSource()))
                .map(Source::getValue)
                .collect(Collectors.toList());

        return computationFactory.getComputation(computationParams.getOperationType())
                .calculate(values);
    }
}

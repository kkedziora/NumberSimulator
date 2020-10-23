package com.example.simulator.operation;

import com.example.simulator.operation.integer.IntegerOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OperationFacade {

    private final Operation<Integer> integerOperationService;

    @Autowired
    public OperationFacade(IntegerOperationService integerOperationService) {
        this.integerOperationService = integerOperationService;
    }

    public Integer getIntResult(CalculationParams calculationParams) {
        return integerOperationService.getResult(calculationParams);
    }
}

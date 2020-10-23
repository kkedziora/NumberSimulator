package com.example.simulator;

import com.example.simulator.operation.CalculationParams;
import com.example.simulator.operation.OperationFacade;
import com.example.simulator.operation.OperationType;
import com.example.simulator.source.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(value = "/api/number-operations/results")
class NumberOperationController {

    private final OperationFacade randomOperationFacade;

    @Autowired
    public NumberOperationController(OperationFacade randomOperationFacade) {
        this.randomOperationFacade = randomOperationFacade;
    }

    @GetMapping("/integers")
    public ResponseEntity<Integer> getResult(@RequestParam("operationType") OperationType operationType,
                                             @RequestParam("sources") Set<SourceType> sources) {


        CalculationParams calculationParams = new CalculationParams(operationType, sources);
        Integer result = randomOperationFacade.getIntResult(calculationParams);
        return ResponseEntity.ok(result);
    }
}

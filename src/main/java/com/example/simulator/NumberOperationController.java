package com.example.simulator;

import com.example.simulator.operation.ComputationParams;
import com.example.simulator.operation.GeneratedValue;
import com.example.simulator.operation.Operation;
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

    private final Operation operation;

    @Autowired
    public NumberOperationController(Operation operation) {
        this.operation = operation;
    }

    @GetMapping("/integers")
    public ResponseEntity<Integer> getResult(@RequestParam("operationType") OperationType operationType,
                                             @RequestParam("sources") Set<SourceType> sources) {


        ComputationParams computationParams = new ComputationParams(operationType, sources);
        GeneratedValue result = operation.getResult(computationParams);
        return ResponseEntity.ok(result.asNumber());
    }
}

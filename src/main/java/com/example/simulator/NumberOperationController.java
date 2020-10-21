package com.example.simulator;

import com.example.simulator.operation.OperationFacade;
import com.example.simulator.operation.OperationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/number-operations/results")
class NumberOperationController {

    private final OperationFacade randomOperationFacade;

    @Autowired
    public NumberOperationController(OperationFacade randomOperationFacade) {
        this.randomOperationFacade = randomOperationFacade;
    }

    @GetMapping("/integers")
    public ResponseEntity<Integer> getResult(@RequestParam("operationType") OperationType operationType) {

        Integer result = randomOperationFacade.getIntResult(operationType);
        return ResponseEntity.ok(result);
    }
}

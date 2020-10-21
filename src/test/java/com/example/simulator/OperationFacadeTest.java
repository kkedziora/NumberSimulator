package com.example.simulator;

import com.example.simulator.operation.OperationFacade;
import com.example.simulator.operation.OperationType;
import com.example.simulator.operation.integer.IntegerOperationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class OperationFacadeTest {


    @InjectMocks
    private OperationFacade operationFacade;
    @Mock
    private IntegerOperationService integerOperationService;

    @Test
    void testGetIntResult() {

        when(integerOperationService.getResult(OperationType.ADDITION)).thenReturn(201);

        Integer result = operationFacade.getIntResult(OperationType.ADDITION);
        assertThat(result).isEqualTo(201);
    }
}
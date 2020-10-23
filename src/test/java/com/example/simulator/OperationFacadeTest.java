package com.example.simulator;

import com.example.simulator.operation.CalculationParams;
import com.example.simulator.operation.OperationFacade;
import com.example.simulator.operation.OperationType;
import com.example.simulator.operation.integer.IntegerOperationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.util.collections.Sets;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.example.simulator.source.SourceType.SYSTEM;
import static com.example.simulator.source.SourceType.WEB;
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
        CalculationParams calculationParams = new CalculationParams(OperationType.ADDITION, Sets.newSet(WEB, SYSTEM));

        when(integerOperationService.getResult(calculationParams)).thenReturn(201);

        Integer result = operationFacade.getIntResult(calculationParams);
        assertThat(result).isEqualTo(201);
    }
}
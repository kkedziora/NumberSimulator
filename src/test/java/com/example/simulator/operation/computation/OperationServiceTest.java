package com.example.simulator.operation.computation;

import com.example.simulator.operation.ComputationParams;
import com.example.simulator.operation.GeneratedValue;
import com.example.simulator.operation.OperationService;
import com.example.simulator.operation.OperationType;
import com.example.simulator.source.Source;
import com.example.simulator.source.number.RandomIntegerSource;
import com.example.simulator.source.number.WebRandomIntegerSource;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.internal.util.collections.Sets;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.example.simulator.source.SourceType.SYSTEM;
import static com.example.simulator.source.SourceType.WEB;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OperationServiceTest {

    private OperationService operationService;

    @Mock
    private RandomIntegerSource randomIntegerSource;
    @Mock
    private WebRandomIntegerSource webRandomIntegerSource;


    @BeforeEach
    public void setUp() {
        List<Source> sources = Lists.newArrayList(randomIntegerSource, webRandomIntegerSource);
        AddComputation addComputation = new AddComputation();
        ComputationFactory computationFactory = new ComputationFactory(Lists.newArrayList(addComputation));
        operationService = new OperationService(sources, computationFactory);
    }

    @Test
    void testAddition_expectedSuccess() {
        ComputationParams computationParams = new ComputationParams(OperationType.ADDITION, Sets.newSet(WEB, SYSTEM));
        when(randomIntegerSource.getSource()).thenReturn(SYSTEM);
        when(webRandomIntegerSource.getSource()).thenReturn(WEB);
        when(randomIntegerSource.getValue()).thenReturn(new GeneratedValue(11));
        when(webRandomIntegerSource.getValue()).thenReturn(new GeneratedValue(12));

        GeneratedValue result = operationService.getResult(computationParams);

        assertThat(result.asNumber()).isEqualTo(23);
    }
}
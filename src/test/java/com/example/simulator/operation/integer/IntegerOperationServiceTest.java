package com.example.simulator.operation.integer;

import com.example.simulator.operation.CalculationParams;
import com.example.simulator.operation.OperationType;
import com.example.simulator.source.number.integer.IntegerSource;
import com.example.simulator.source.number.integer.RandomIntegerSource;
import com.example.simulator.source.number.integer.WebRandomIntegerSource;
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
class IntegerOperationServiceTest {

    private IntegerOperationService integerOperationService;

    @Mock
    private RandomIntegerSource randomIntegerSource;
    @Mock
    private WebRandomIntegerSource webRandomIntegerSource;


    @BeforeEach
    public void setUp() {
        List<IntegerSource> integerSources = Lists.newArrayList(randomIntegerSource, webRandomIntegerSource);
        AddIntegerComputation addIntegerComputation = new AddIntegerComputation();
        IntegerOperationFactory integerOperationFactory = new IntegerOperationFactory(Lists.newArrayList(addIntegerComputation));
        integerOperationService = new IntegerOperationService(integerSources, integerOperationFactory);
    }

    @Test
    void testAddition_expectedSuccess() {
        CalculationParams calculationParams = new CalculationParams(OperationType.ADDITION, Sets.newSet(WEB, SYSTEM));
        when(randomIntegerSource.getSource()).thenReturn(SYSTEM);
        when(webRandomIntegerSource.getSource()).thenReturn(WEB);
        when(randomIntegerSource.getValue()).thenReturn(11);
        when(webRandomIntegerSource.getValue()).thenReturn(12);

        Integer result = integerOperationService.getResult(calculationParams);

        assertThat(result).isEqualTo(23);
    }
}
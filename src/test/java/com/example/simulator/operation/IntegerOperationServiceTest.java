package com.example.simulator.operation;

import com.example.simulator.operation.integer.IntegerOperationService;
import com.example.simulator.source.number.integer.IntegerSource;
import com.example.simulator.source.number.integer.RandomIntegerSource;
import com.example.simulator.source.number.integer.WebRandomIntegerSource;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

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
        integerOperationService = new IntegerOperationService(integerSources);
    }

    @Test
    void testAddition_expectedSuccess() {

        when(randomIntegerSource.getNumber()).thenReturn(11);
        when(webRandomIntegerSource.getNumber()).thenReturn(12);
        Integer result = integerOperationService.getResult(OperationType.ADDITION);

        assertThat(result).isEqualTo(23);
    }
}
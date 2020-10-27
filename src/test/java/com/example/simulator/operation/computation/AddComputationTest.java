package com.example.simulator.operation.computation;

import com.example.simulator.operation.GeneratedValue;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class AddComputationTest {

    private AddComputation addComputation;

    @BeforeEach
    public void setUp() {
        addComputation = new AddComputation();
    }

    @ParameterizedTest
    @MethodSource("getTestValues")
    void calculate(List<GeneratedValue> values, Integer expectedResult) {

        GeneratedValue result = addComputation.calculate(values);
        assertThat(result.asNumber()).isEqualTo(expectedResult);
    }


    private static Stream<Arguments> getTestValues() {
        return Stream.of(
                Arguments.of(Lists.newArrayList(new GeneratedValue(0), new GeneratedValue(0)), 0),
                Arguments.of(Lists.newArrayList(new GeneratedValue(10), new GeneratedValue(2)), 12),
                Arguments.of(Lists.newArrayList(new GeneratedValue(-11), new GeneratedValue(12)), 1),
                Arguments.of(Lists.newArrayList(new GeneratedValue(300), new GeneratedValue(-100)), 200)
        );
    }
}
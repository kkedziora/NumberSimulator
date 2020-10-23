package com.example.simulator.operation.integer;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SubtractIntegerComputationTest {

    private SubtractIntegerComputation subtractIntegerComputation;

    @BeforeEach
    public void setUp() {
        subtractIntegerComputation = new SubtractIntegerComputation();
    }

    @ParameterizedTest
    @MethodSource("getTestValues")
    void calculate(List<Integer> values, Integer expectedResult) {

        Integer result = subtractIntegerComputation.calculate(values);
        assertThat(result).isEqualTo(expectedResult);
    }


    private static Stream<Arguments> getTestValues() {
        return Stream.of(
                Arguments.of(Lists.newArrayList(0, 0), 0),
                Arguments.of(Lists.newArrayList(10, 2), 8),
                Arguments.of(Lists.newArrayList(-11, 12), -23),
                Arguments.of(Lists.newArrayList(300, -100), 400)
        );
    }
}
package com.example.simulator.operation.integer;

import com.example.simulator.operation.ArithmeticOperation;
import com.example.simulator.operation.OperationType;
import org.assertj.core.util.Lists;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class AddIntegerOperationTest {

    @ParameterizedTest
    @MethodSource("getTestValues")
    void calculate(List<Integer> values, Integer expectedResult) {

        ArithmeticOperation<Integer> addIntegerOperation
                = IntegerOperationFactory.getCalculationFor(OperationType.ADDITION);

        Integer result = addIntegerOperation.calculate(values);
        assertThat(result).isEqualTo(expectedResult);
    }


    private static Stream<Arguments> getTestValues() {
        return Stream.of(
                Arguments.of(Lists.newArrayList(0, 0), 0),
                Arguments.of(Lists.newArrayList(10, 2), 12),
                Arguments.of(Lists.newArrayList(-11, 12), 1),
                Arguments.of(Lists.newArrayList(300, -100), 200)
        );
    }
}
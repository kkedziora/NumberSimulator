package com.example.simulator.source.number.integer;

import com.example.simulator.operation.OperationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WebRandomIntegerSourceTest {

    @InjectMocks
    private WebRandomIntegerSource webRandomIntegerSource;
    @Mock
    private RestTemplate restTemplate;

    private static Stream<Arguments> getTestValues() {
        return Stream.of(
                Arguments.of("1", 1),
                Arguments.of(" 2", 2),
                Arguments.of("3 ", 3)
        );
    }

    @ParameterizedTest
    @MethodSource("getTestValues")
    void getNumberFromWeb_expectedSuccess(String returnValue, Integer expectedResult) {
        ResponseEntity<String> response = ResponseEntity.ok(returnValue);
        when(restTemplate.getForEntity(anyString(), eq(String.class))).thenReturn(response);

        Integer result = webRandomIntegerSource.getValue();

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getNumberFromWeb_expectedBadRequest() {
        ResponseEntity<String> response = ResponseEntity.badRequest().build();
        when(restTemplate.getForEntity(anyString(), eq(String.class))).thenReturn(response);

        assertThatExceptionOfType(OperationException.class)
                .isThrownBy(() -> webRandomIntegerSource.getValue());

    }
}
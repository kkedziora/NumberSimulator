package com.example.simulator;

import com.example.simulator.operation.ComputationParams;
import com.example.simulator.operation.GeneratedValue;
import com.example.simulator.operation.OperationService;
import com.example.simulator.operation.OperationType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.internal.util.collections.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static com.example.simulator.source.SourceType.SYSTEM;
import static com.example.simulator.source.SourceType.WEB;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(NumberOperationController.class)
class NumberOperationControllerTest {

    private final String API = "/api/number-operations/results";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OperationService operationService;

    @Test
    void testIntegerAddition_expectedSuccess() throws Exception {
        ComputationParams computationParams = new ComputationParams(OperationType.ADDITION, Sets.newSet(WEB, SYSTEM));
        when(operationService.getResult(computationParams)).thenReturn(new GeneratedValue(101));

        this.mockMvc.perform(get(API + "/integers?operationType=ADDITION&sources=WEB&sources=SYSTEM"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("101"));
    }

    @Test
    void testInteger_expectedBadOperationType() throws Exception {
        this.mockMvc.perform(get(API + "/integers?operationType=abab&sources=WEB"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}
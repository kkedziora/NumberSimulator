package com.example.simulator;

import com.example.simulator.source.number.integer.RandomIntegerSource;
import com.example.simulator.source.number.integer.WebRandomIntegerSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OperationFacadeIntegrationTest {

    private static final String API = "/api/number-operations/results";

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private WebRandomIntegerSource webRandomIntegerSource;
    @MockBean
    private RandomIntegerSource randomIntegerSource;

    @Test
    void test_expectedSuccess() throws Exception {
        when(webRandomIntegerSource.getNumber()).thenReturn(99);
        when(randomIntegerSource.getNumber()).thenReturn(101);

        this.mockMvc.perform(get(API + "/integers?operationType=ADDITION"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("200"));
    }
}

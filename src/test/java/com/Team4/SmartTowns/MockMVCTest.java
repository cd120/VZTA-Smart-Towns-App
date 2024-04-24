package com.Team4.SmartTowns;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MockMVCTest {

    @Autowired
    private MockMvc mockMvc;

//    Unit tests using a mock MVC
    @Test
    public void testLoginPageRendersCorrectly() throws Exception {
        this.mockMvc.perform(get("/trails"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("cardiff")));
    }
    //test using a mock MVC but a with a test database
    @Test
    public void testMockMVC() throws Exception {
        this.mockMvc.perform(get("/trails"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("mockCardiff")));
    }

}

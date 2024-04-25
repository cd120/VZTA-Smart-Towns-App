package com.Team4.SmartTowns;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
public class MockMVCTest2 {


    @Autowired
    private MockMvc mockMvc;

    //   testing h2 database connection, "fake bronze" comes back as success.
    @Test
    public void testMockDbMedal() throws Exception {
        this.mockMvc.perform(get("/medals"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("fake silver")));
    }


}
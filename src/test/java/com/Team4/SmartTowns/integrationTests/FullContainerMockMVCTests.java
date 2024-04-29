package com.Team4.SmartTowns.integrationTests;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@ActiveProfiles("test")
public class FullContainerMockMVCTests {


    @Autowired
    private MockMvc mockMvc;

    //   testing if path / contains Welcome, test passes.
    @Test
    public void testGreetingPage() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Welcome")));
    }


    //   testing mock db path /medals contains string mockBronze in h2 database, test passes.
    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    public void testMockDbMedal() throws Exception {
        this.mockMvc.perform(get("/medals"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("mockBronze")));
    }


}
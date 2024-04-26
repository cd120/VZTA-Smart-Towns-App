package com.Team4.SmartTowns;

import com.Team4.SmartTowns.medals.controller.MedalController;
import com.Team4.SmartTowns.medals.service.MedalService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.BDDAssumptions.given;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(properties = { "Spring.config.location=classpath:application.properties" })
@AutoConfigureMockMvc

public class FullContainerMockMVCTests {

    @Autowired
    private MockMvc mockMvc;

    //Tests access to mock MVC.
    @Test
    public void greetingTest() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Welcome")));
    }

    //Test using the mock mvc with a mock database.
    @Test
    public void getMedalTest() throws Exception {
        this.mockMvc.perform(get("/medals")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("mockBronze")));
    }




}
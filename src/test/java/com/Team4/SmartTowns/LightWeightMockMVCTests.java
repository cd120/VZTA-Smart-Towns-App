package com.Team4.SmartTowns;

import com.Team4.SmartTowns.medals.controller.MedalController;
import com.Team4.SmartTowns.medals.model.Medal;
import com.Team4.SmartTowns.medals.model.MedalRepository;
import com.Team4.SmartTowns.medals.service.MedalService;
import com.Team4.SmartTowns.medals.service.MedalServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.BDDAssumptions.given;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@WebMvcTest(MedalController.class)


public class LightWeightMockMVCTests {


    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private MedalService medalService;

    //Testing container, finds "Welcome", test passes.
    @Test
//    @WithMockUser(username = "user", roles = {"USER"})
    public void testMockDbMedal() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Welcome")));
    }

    //Testing new medal, does not use any db, test passes.
    @Test
    public void getMedalTest() throws Exception {

        Medal medal = new Medal("mockSilver", "fake silver");

        BDDMockito.given(this.medalService.getAllMedals()).willReturn(Arrays.asList(medal));

        this.mockMvc.perform(get("/medals"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("mockSilver")));
    }

    private BDDMockito given(List<Medal> medalList) {
        return null;
    }


}

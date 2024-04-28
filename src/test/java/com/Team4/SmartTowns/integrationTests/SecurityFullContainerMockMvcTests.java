package com.Team4.SmartTowns.integrationTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class SecurityFullContainerMockMvcTests {

    @Autowired
    private MockMvc mockMvc;

    // full mock mvc with security tests user with no admin rights accessing path /admin/** returns 403 error, test passes.
    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    public void testAddTrailPageNotAdmin() throws Exception {
        this.mockMvc.perform(get("/admin/trails/add")
                        .with(SecurityMockMvcRequestPostProcessors.user("user").roles("USER")))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

}


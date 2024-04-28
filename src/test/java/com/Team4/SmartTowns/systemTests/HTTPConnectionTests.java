package com.Team4.SmartTowns.systemTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.security.test.context.support.WithMockUser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

//@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HTTPConnectionTests {

    @Value(value="${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;


    //can access server, by requesting server index page /, finding "Welcome", test passes.

    @Test

    public void greetingTest() throws Exception {
        assert this.restTemplate.getForObject("http://localhost:" + port + "/", String.class).contains("Welcome");
    }


    //testing connection to /medals, and string "medals" can be found, test passes.
    @Test
    public void medalsPageTest() throws Exception {
        assert this.restTemplate.getForObject("http://localhost:" + port + "/medals", String.class).contains("BRONZE");
    }


    //testing no access to mock db, mockBronze does not exist in main db, test passes.
    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    public void dbMedalTest() throws Exception {
        assertFalse(this.restTemplate.getForObject("http://localhost:" + port + "/medals", String.class).contains ("mockBronze"));
    }
}
package com.Team4.SmartTowns;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;
import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("dev")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HTTPConnectionTest {

    @Value(value="${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;


    //can access server, by injecting request to server to welcome page, finding "Welcome", test passes.
    @Test
    public void greetingTest() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port, String.class)).contains ("Welcome");
    }


    //testing connection to /medals, and string "medals" can be found, test passes.
    @Test
    public void medalsPageTest() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/medals", String.class)).contains ("medals");
    }


    //can access the mock database , finding medal "mockBronze", test passes.
    @Test
    public void dbMedalTest() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/medals", String.class)).contains ("mockBronze");
    }
}
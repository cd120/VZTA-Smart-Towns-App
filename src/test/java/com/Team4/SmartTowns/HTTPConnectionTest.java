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


    //can access server, by injecting request to server.
    @Test
    public void greetingTest() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port, String.class)).contains ("Welcome");
    }

    @Test
    public void testConnection() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/trails", String.class)).contains ("trails");
    }

    //can access the database, finding profile name "emma"
    @Test
    public void dbProfileTest() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/leaderboard", String.class)).contains ("emma");
    }
}
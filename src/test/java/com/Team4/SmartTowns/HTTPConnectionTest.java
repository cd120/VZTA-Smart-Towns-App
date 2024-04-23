package com.Team4.SmartTowns;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.client.RestTemplate;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HTTPConnectionTest {

    @Value(value="${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

//    @Test
//    public void testConnection() throws Exception {
//        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/login", String.class)).contains ("Username");
//    }

//    @Test
//    public void testMockMVC() throws Exception {
//        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/trails", String.class)).contains ("mockCardiff");
//    }
}
package com.Team4.SmartTowns.integrationTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;


//Testing mock db is set up properly with data injection
@SpringBootTest
@ActiveProfiles("test")
public class PropertyLoadingTest {

    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @Test
    public void testDataSourceUrl() {
        System.out.println("DataSource URL: " + dataSourceUrl);
        assertEquals("jdbc:h2:mem:testdb", dataSourceUrl);
    }
}

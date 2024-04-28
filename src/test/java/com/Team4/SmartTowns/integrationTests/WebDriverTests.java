package com.Team4.SmartTowns.integrationTests;

import io.github.bonigarcia.wdm.WebDriverManager;
//import lombok.Value;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebDriverTests {
    @Value("${local.server.port}")
    private int port;

    WebDriver webDriver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach
    void setupTest() {
        FirefoxOptions options = new FirefoxOptions();;
        options.addArguments("--headless");
        webDriver = new FirefoxDriver(options);
    }

    @AfterEach
    public void teardown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    // Tests using firefox driver to find string Welcome on element "h1" on index page.
    // Test passes.
    @Test
    public void testGreetingPage() {
        this.webDriver.get("http://localhost:" + port + "/");
        assert webDriver.findElement(By.cssSelector("h1")).getText().contains("Welcome");
    }

    // Tests admin add trail is secure, carries out login process, finds Create Trail.
    // Test passes!
    @Test
    public void testAdminPageSecurity() {
        this.webDriver.get("http://localhost:" + port + "/admin/trails/add");
        this.webDriver.findElement(By.name("username")).sendKeys("admin");
        this.webDriver.findElement(By.name("password")).sendKeys("admin");
        this.webDriver.findElement(By.id("SignIn")).click();
        this.webDriver.get("http://localhost:" + port + "/admin/trails/add");
        assertTrue(webDriver.findElement(By.cssSelector("h1")).getText().contains("Create Trail"));

    }

    // Tests path to /profile page before login, but is redirected to /login
    // Test passes, user is redirected to /login.
    @Test
    public void testLoginPageSecurity() {
        this.webDriver.get("http://localhost:" + port + "/profile");
        assert webDriver.getCurrentUrl().endsWith("/login");
    }

     //Tests admin login and creates new trail for sausage rolls.
     //Test passes, new trail for sausage rolls created.
    @Test
    public void testAdminCreateTrails() {
        this.webDriver.get("http://localhost:" + port + "/admin/trails/add");
        this.webDriver.findElement(By.name("username")).sendKeys("admin");
        this.webDriver.findElement(By.name("password")).sendKeys("admin");
        this.webDriver.findElement(By.id("SignIn")).click();
        this.webDriver.get("http://localhost:" + port + "/admin/trails/add");
        this.webDriver.findElement(By.id("trailName")).sendKeys("Greggs");
        this.webDriver.findElement(By.id("trailDescription")).sendKeys("Julian Hodge to Greggs for sausage rolls!");
        this.webDriver.findElement(By.id("createTrail")).click();
        this.webDriver.get("http://localhost:" + port + "/trails");
        assertTrue(webDriver.findElement(By.id("trailContainer")).getText().contains("sausage roll"));
    }


}

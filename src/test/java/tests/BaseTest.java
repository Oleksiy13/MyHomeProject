package tests;

import context.TestContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigurationReader;
import utils.DriverFactory;
import io.qameta.allure.junit5.AllureJunit5;

import java.time.Duration;

@ExtendWith(AllureJunit5.class)
public class BaseTest {
    TestContext context;



    @BeforeEach
    public void before() {
        context = new TestContext();
        context.driver = DriverFactory.getDriver();
        long duration = Long.parseLong(ConfigurationReader.get("timeout"));
        context.wait = new WebDriverWait(context.driver, Duration.ofSeconds(duration));
        context.action = new Actions(context.driver);
        context.driver.get(ConfigurationReader.get("url"));

    }

    @AfterEach
    public void after() {
        if (context.driver != null) {
            context.driver.quit();
        }
    }
}

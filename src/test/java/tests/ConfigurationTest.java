package tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import utils.ConfigurationReader;

public class ConfigurationTest {

    @Test
    public void testConfiguration(){
        String url = ConfigurationReader.get("url");
        String browser = ConfigurationReader.get("browser");

        assertNotNull(url, "URL должен быть задан");
        assertEquals("chrome", browser, "Браузер должен быть chrome");
    }
}

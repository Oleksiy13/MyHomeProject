package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    public static WebDriver getDriver(){

        WebDriver driver = null;
        String browser = ConfigurationReader.get("browser");
        // Получаем параметры браузера, headless и maximize из конфигурационного файла
        boolean headless = Boolean.parseBoolean(ConfigurationReader.get("headless"));
        boolean maximize = Boolean.parseBoolean(ConfigurationReader.get("maximize"));

        // Выбор браузера на основе конфигурации
        switch (browser.toLowerCase()){

            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();

                if (headless){
                    chromeOptions.addArguments("--headless");
                }

                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();

                if (headless){
                    firefoxOptions.addArguments("--headless");
                }
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();

                if (headless) {
                    edgeOptions.addArguments("--headless");
                }
                    driver = new EdgeDriver(edgeOptions);
                    break;

            default:
                throw new WebDriverException("Параметр browser не выбран в конфигурации configuration.properties");
        }

        if (maximize){
            driver.manage().window().maximize();
        }

        return driver;
    }
}

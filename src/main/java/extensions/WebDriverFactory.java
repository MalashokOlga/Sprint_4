package extensions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

import static config.AppConfig.URL;
import static config.WebDriverConfig.WAIT_SECONDS_TIMEOUT;

public class WebDriverFactory {
    public static WebDriver get() {
        String browserName = System.getenv().get("browser");

         WebDriver driver;


        switch (browserName) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "C:/WebDriver/bin/geckodriver.exe");
                FirefoxOptions optionsf = new FirefoxOptions();
                optionsf.addArguments("--headless");
                //optionsf.setLogLevel(FirefoxDriverLogLevel.TRACE);
                driver = new FirefoxDriver(optionsf);
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default: throw new RuntimeException("Browser " + browserName + " not exist");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_SECONDS_TIMEOUT));
        driver.navigate().to(URL);
        return driver;
    }

}

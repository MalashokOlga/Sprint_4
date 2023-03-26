import extensions.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import pages.MainPage;

import static junit.framework.TestCase.assertTrue;//????

public class ClickOrderButtonTest {
    private WebDriver driver;

    @Before
    public void setup() {
        driver = WebDriverFactory.get();
    }
    @Test
    public void checkClickOrderButtonUp() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickBtnOrderUp();
    }

    //public void checkClickPriceQuestion() {
    //    MainPage mainPage = new MainPage(driver);
    //    mainPage.clickBtnPriceQuestion();
    //}

    @After
    public void teardown() {
        driver.quit();
    }

}

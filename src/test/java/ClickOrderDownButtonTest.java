import extensions.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

//тест клика на нижнюю кнопку "Заказать"
public class ClickOrderDownButtonTest {
    private WebDriver driver;

    @Before
    public void setup() {
        driver = WebDriverFactory.get();
    }
    @Test
    public void checkClickOrderButtonDown() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickBtnCookie();
        mainPage.clickBtnOrderDown();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}

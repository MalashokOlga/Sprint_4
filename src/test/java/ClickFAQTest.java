import extensions.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import static org.hamcrest.CoreMatchers.is;
import org.hamcrest.MatcherAssert;

@RunWith(Parameterized.class)
//тест проверяет выпадающий список раздела "Вопросы о важном": когда нажимаешь на стрелочку, открывается соответствующий текст
public class ClickFAQTest {
    private WebDriver driver;

    @Parameterized.Parameter
    public String questionLocator;

    @Parameterized.Parameter(1)
    public String answerLocator;

    @Parameterized.Parameter(2)
    public String textAnswer;

    @Parameterized.Parameters(name = "{index}: вопросы и ответы" )
    public static Object[][] faqData() {
        return new Object[][] {
                {".//*[@id='accordion__heading-0']", ".//*[@id='accordion__panel-0']", "Сутки — 400 рублей. Оплата курьеру — наличными или картой." },
                {"//*[@id='accordion__heading-1']", ".//*[@id='accordion__panel-1']", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим." },
                {".//*[@id='accordion__heading-2']", ".//*[@id='accordion__panel-2']", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {".//*[@id='accordion__heading-3']", ".//*[@id='accordion__panel-3']", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {".//*[@id='accordion__heading-4']", ".//*[@id='accordion__panel-4']", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {".//*[@id='accordion__heading-5']", ".//*[@id='accordion__panel-5']", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {".//*[@id='accordion__heading-6']", ".//*[@id='accordion__panel-6']", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {".//*[@id='accordion__heading-7']", ".//*[@id='accordion__panel-7']", "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        };
    }

    @Before
    public void setup() {
        driver = WebDriverFactory.get();
    }
    @Test
    public void checkClickPriceQuestion() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickBtnCookie(); // клик по кнопке "Да все привыкли"
        mainPage.faqList(questionLocator, answerLocator); //поиск нужного вопроса и клик на него
        MatcherAssert.assertThat("Текст не совпадает", mainPage.faqAnswText(answerLocator), is(textAnswer));//сравнение текста из параметра и текста со страницы
    }
    @After
    public void teardown() {
        driver.quit();
    }
}

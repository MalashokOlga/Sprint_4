import extensions.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pages.*;
import org.junit.runner.RunWith;


@RunWith(Parameterized.class)
//тест клика на обе кнопки "Заказать" и заполнения полей заказа
public class ClickOrderButtonTest {
    private WebDriver driver;
    @Parameterized.Parameter
    public String name;
    @Parameterized.Parameter(1)
    public String surname;
    @Parameterized.Parameter(2)
    public String address;
    @Parameterized.Parameter(3)
    public String station;
    @Parameterized.Parameter(4)
    public String phone;
    @Parameterized.Parameter(5)
    public String date;
    @Parameterized.Parameter(6)
    public String period;
    @Parameterized.Parameter(7)
    public String colour;
    @Parameterized.Parameter(8)
    public String comment;
    @Parameterized.Parameter(9)
    public String button;

    @Parameterized.Parameters(name = "{index}: данные для заказа" )
    public static Object[][] userData() {
        return new Object[][] {
                { "Оля", "Мал", "Саратовская", "Волгоград", "89998887766", "9", "двое суток", "серый", "хочу самокат", "низ" },
                { "Ваня", "Петров", "Южная", "Таганская", "89992227766", "8", "трое суток", "черный", "очень хочу самокат", "верх" } //не работает без комменатрия
        };
    }

    @Before
    public void setup() {
        driver = WebDriverFactory.get();
    }

    @Test
    public void checkClickOrderButtonUp() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickBtnCookie();
        mainPage.clickBtnOrder(button);

        OrderPage1 orderPage1 = new OrderPage1(driver);
        orderPage1.setCustomerName(name);
        orderPage1.setCustomerSurname(surname);
        orderPage1.setAddress(address);
        orderPage1.clickMetroStationInput();
        orderPage1.searchMetroStation(station);
        orderPage1.setPhone(phone);
        orderPage1.clickBtnNext();

        OrderPage2 orderPage2 = new OrderPage2(driver);
        orderPage2.clickDeliveryDate();
        orderPage2.clickCalendar(date);
        orderPage2.clickPeriodList(period);
        orderPage2.clickSetColour(colour);
        orderPage2.setComment(comment);
        orderPage2.clickBtnOrder();

        ConfirmOrderPopup confirmOrderPopup = new ConfirmOrderPopup(driver);
        //confirmOrderPage.clickBtnNo();// клик по кнопке "Нет" в качестве проверки, что окно появляется, т.к. кнопка "Да" не работает в chrome
        confirmOrderPopup.clickBtnYes();
        confirmOrderPopup.isSuccessVisible();
        confirmOrderPopup.clickBtnStatus();
    }

    @After
    public void teardown() {
        driver.quit();
    }

}

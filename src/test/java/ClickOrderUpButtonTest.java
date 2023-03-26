import extensions.WebDriverFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pages.*;
import org.junit.runner.RunWith;


@RunWith(Parameterized.class)
//тест клика на верхнюю кнопку "Заказать" и заполнения полей заказа
public class ClickOrderUpButtonTest {
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

    @Parameterized.Parameters(name = "{index}: данные для заказа" )
    public static Object[][] userData() {
        return new Object[][] {
                { "Оля", "Мал", "Саратовская", "Волгоград", "89998887766", "9", "двое суток", "серый", "хочу самокат" },
                { "Ваня", "Петров", "Южная", "Таганская", "89992227766", "8", "трое суток", "черный", "очень хочу самокат" } //не работает без комменатрия
        };
    }

    @Before
    public void setup() {
        driver = WebDriverFactory.get();
    }

    @Test
    //клик на кнопку "Заказать" и заполнение полей заказа
    public void checkClickOrderButtonUp() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickBtnCookie();// клик по кнопке "Да все привыкли"
        mainPage.clickBtnOrderUp();// клик по кнопке "Заказать"
    //заполняем поля страницы "Для кого самокат"
        OrderPage1 orderPage1 = new OrderPage1(driver);
        orderPage1.setCustomerName(name);//добавили имя
        orderPage1.setCustomerSurname(surname);//добавили фамилию
        orderPage1.setAddress(address);//добавили адрес
        orderPage1.clickMetroStationInput();//клик по полю "Станция метро"
        orderPage1.searchMetroStation(station); //поиск нужной станции
        orderPage1.setPhone(phone);//добавили телефон
        orderPage1.clickBtnNext();//клик по кнопке "Далее"
    //заполняем поля страницы "Про аренду"
        OrderPage2 orderPage2 = new OrderPage2(driver);
        orderPage2.clickDeliveryDate();//клик по полю "Когда привезти самокат"
        orderPage2.clickCalendar(date);//выбираем дату, можно объединить в один метод с предыдущим
        //orderPage2.clickRentalPeriod();//клик по полю "Срок аренды"
        orderPage2.clickPeriodList(period);//выбираем срок аренды
        orderPage2.clickSetColour(colour); //выбор цвета самоката
        orderPage2.setComment(comment); //добавить комментарий
        orderPage2.clickBtnOrder(); //клик по кнопке "Заказать"
    //проверить 2 всплывающих окна
        ConfirmOrderPage confirmOrderPage = new ConfirmOrderPage(driver);
        //confirmOrderPage.clickBtnNo();// клик по кнопке "Нет" в качестве проверки, что окно появляется, т.к. кнопка "Да" не работает в chrome
        confirmOrderPage.clickBtnYes();// клик по кнопке "Да"
        confirmOrderPage.isSuccessVisible();//проверка всплывающего окна "Заказ оформлен"
        confirmOrderPage.clickBtnStatus();//клик по кнопке "Посмотреть статус"
        //нужна ли проверка, что происходит переход на страницу с данными о заказе??
        //SuccessOrderPage successOrderPage = new SuccessOrderPage(driver);
        //successOrderPage.isSuccessVisible();//проверка всплывающего окна "Заказ оформлен"
        //successOrderPage.clickBtnStatus();//клик по кнопке "Посмотреть статус"
    }

    @After
    public void teardown() {
        driver.quit();
    }

}

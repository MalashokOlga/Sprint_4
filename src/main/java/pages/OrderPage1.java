package pages;

import org.openqa.selenium.*;

public class OrderPage1 {

    //поле драйвер
    private final WebDriver driver;

    //поле ввода "Имя"
    private final By customerName = By.xpath(".//*[@placeholder='* Имя']");

    //поле ввода "Фамилия"
    private final By customerSurname = By.xpath(".//*[@placeholder='* Фамилия']");

    //поле ввода "Адрес"
    private final By address = By.xpath(".//*[@placeholder='* Адрес: куда привезти заказ']");

    //поле ввода/поиска/выпадающий список "Станция метро" как сделать поиск??
    private final By metroStationInput = By.xpath(".//*[@placeholder='* Станция метро']");

    //выпадающий список станций
    private final By stationList = By.xpath(".//*[@class='select-search__input']");

    //поле ввода "Телефон"
    private final By phone = By.xpath(".//*[@placeholder='* Телефон: на него позвонит курьер']");

    //кнопка "Далее"
    private final By btnNext = By.xpath(".//*[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //конструктор класса OrderPage1
    public OrderPage1(WebDriver driver) {
        this.driver = driver;
    }

    //метод заполнения поля "Имя"
    public OrderPage1 setCustomerName(String custName) {
        driver.findElement(customerName).sendKeys(custName);
        return this;
    }

    //метод заполнения поля "Фамилия"
    public OrderPage1 setCustomerSurname(String custSurname) {
        driver.findElement(customerSurname).sendKeys(custSurname);
        return this;
    }

    //метод заполнения поля "Адрес"
    public OrderPage1 setAddress(String custAddr) {
        driver.findElement(address).sendKeys(custAddr);
        return this;
    }

    //метод клика по полю "Станция метро"
    public OrderPage1 clickMetroStationInput() {
        driver.findElement(metroStationInput).click();
        return this;
    }

    //метод клика по выпадающему списку "Станция метро"
    public void searchMetroStation(String station) throws InterruptedException {
        driver.findElement(metroStationInput).click();
        Thread.sleep(500);
        driver.findElement(stationList).sendKeys(station, Keys.ARROW_DOWN, Keys.ENTER );
    }

    //метод заполнения поля "Телефон"
    public OrderPage1 setPhone(String custPhone) {
        driver.findElement(phone).sendKeys(custPhone);
        return this;
    }

    //метод клика по кнопке "Далее"
    public OrderPage1 clickBtnNext() {
        driver.findElement(btnNext).click();
        return this;
    }

}

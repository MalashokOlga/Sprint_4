package pages;

import org.openqa.selenium.*;

public class OrderPage2 {

    //поле драйвер
    private final WebDriver driver;

    //поле "Когда привезти самокат"
    private final By deliveryDate = By.xpath(".//*[@placeholder='* Когда привезти самокат']");

    //выпадающий календарь "Когда привезти самокат"
    private final By calendar = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN react-datepicker-ignore-onclickoutside']");

    //поле "Срок аренды"
    private final By rentalPeriod = By.xpath(".//*[@class='Dropdown-arrow']");

    //выпадающий список "Срок аренды"

    private final By[] periodListItems = {By.xpath(".//*[@class='Dropdown-option' and text()='сутки']"),
            By.xpath(".//*[@class='Dropdown-option' and text()='двое суток']"),
            By.xpath(".//*[@class='Dropdown-option' and text()='трое суток']"),
            By.xpath(".//*[@class='Dropdown-option' and text()='четверо суток']"),
            By.xpath(".//*[@class='Dropdown-option' and text()='пятеро суток']"),
            By.xpath(".//*[@class='Dropdown-option' and text()='шестеро суток']"),
            By.xpath(".//*[@class='Dropdown-option' and text()='семеро суток']")};

    //чекбокс "Цвет" в параметрах теста указываем серый или черный
    private final By setGreyColour = By.xpath(".//*[@id='grey']");
    private final By setBlackColour = By.xpath(".//*[@id='black']");

    //поле "Комментарий"
    private final By setComment = By.xpath(".//*[@placeholder='Комментарий для курьера']");

    //кнопка "Заказать"
    private final By btnOrder = By.xpath(".//*[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public OrderPage2(WebDriver driver) {
        this.driver = driver;
    }

    //метод клика по полю "Когда привезти самокат"
    public OrderPage2 clickDeliveryDate() {
        driver.findElement(deliveryDate).click();
        return this;
    }

    //метод клика по нужной дате
    public void clickCalendar(String data) throws InterruptedException {
        driver.findElement(deliveryDate).click();
        Thread.sleep(500);
        driver.findElement(calendar).sendKeys(data, Keys.ARROW_DOWN, Keys.ENTER );
    }

    //метод клика по полю "Срок аренды" и нужному сроку аренды
    public OrderPage2 clickPeriodList(String period) throws InterruptedException {
        driver.findElement(rentalPeriod).click();
        Thread.sleep(500);
        for (int i = 0; i <= periodListItems.length; i = i + 1) {
            String text = driver.findElement(periodListItems[i]).getText();
            if (period.equals(text)) {
                driver.findElement(periodListItems[i]).click();
                break;
            }
        }
        return this;
    }
    //метод клика по чекбоксу цвета
    public OrderPage2 clickSetColour(String colour) {
        if (colour.equals("серый")) {
            driver.findElement(setGreyColour).click();
        } else {
            driver.findElement(setBlackColour).click();
        }
        return this;
    }

    //метод заполнения поля "комментарий"
    public OrderPage2 setComment(String custComm) {
        driver.findElement(setComment).sendKeys(custComm);
        return this;
    }

    //метод клика по кнопке "Заказать"
    public OrderPage2 clickBtnOrder() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(btnOrder).click();
        return this;
    }

}

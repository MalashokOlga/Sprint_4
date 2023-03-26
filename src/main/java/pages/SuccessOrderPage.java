package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessOrderPage {
    /*/поле драйвер
    private final WebDriver driver;

    //всплывающее окно "Заказ оформлен" - возможноЮ его нужно вставить сюда как поле
    private final By successOrderWindow = By.xpath(".//*[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");

    //кнопка "Посмотреть статус" всплывающего окна "Заказ оформлен"
    private final By btnStatus = By.xpath(".//*[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Посмотреть статус']");

    //конструктор класса SuccessOrderPage
    public SuccessOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //метод проверки появления всплывающего окна "Заказ оформлен"
    public ConfirmOrderPage isSuccessVisible() {
        driver.findElement(successOrderWindow).isDisplayed();
        return this;
    }

    //метод клика по кнопке "Посмотреть статус" во всплавающем окне подтверждения заказа
    public ConfirmOrderPage clickBtnStatus() {
        if (driver.findElement(successOrderWindow).isDisplayed()) {
            driver.findElement(btnStatus).click();
        }
        return this;
    }*/
}

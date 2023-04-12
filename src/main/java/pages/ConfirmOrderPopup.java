package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Всплывающее окно "Хотите оформить заказ?" и всплывающее окно "Заказ оформлен"
public class ConfirmOrderPopup {
    //поле драйвер
    private final WebDriver driver;

    //всплывающее окно "Хотите оформить заказ?"
    private final By orderWindow = By.xpath(".//*[@class='Order_ModalHeader__3FDaJ' and text()='Хотите оформить заказ?']");

    //кнопка "Нет" нужна для проверки, т.к. кнопка "Да" не работает
    private final By btnNo = By.xpath(".//*[@class='Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i' and text()='Нет']");

    //кнопка "Да"
    private final By btnYes = By.xpath(".//*[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");

    //всплывающее окно "Заказ оформлен"
    private final By successOrderWindow = By.xpath(".//*[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");

    //кнопка "Посмотреть статус" всплывающего окна "Заказ оформлен"
    private final By btnStatus = By.xpath(".//*[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Посмотреть статус']");

    //конструктор класса ConfirmOrderPage
    public ConfirmOrderPopup(WebDriver driver) {
        this.driver = driver;
    }

    //метод клика по кнопке "Да"
    public ConfirmOrderPopup clickBtnYes() {
        if (driver.findElement(orderWindow).isDisplayed()) {
            driver.findElement(btnYes).click();
        }
        return this;
    }

    //метод клика по кнопке "Нет"
    public ConfirmOrderPopup clickBtnNo() {
        if (driver.findElement(orderWindow).isDisplayed()) {
            driver.findElement(btnNo).click();
        }
        return this;
    }

    //метод проверки появления всплывающего окна "Заказ оформлен"
    public ConfirmOrderPopup isSuccessVisible() {
        driver.findElement(successOrderWindow).isDisplayed();
        return this;
    }

    //метод клика по кнопке "Посмотреть статус" во всплывающем окне подтверждения заказа
    public ConfirmOrderPopup clickBtnStatus() {
        if (driver.findElement(successOrderWindow).isDisplayed()) {
            driver.findElement(btnStatus).click();
        }
        return this;
    }
}

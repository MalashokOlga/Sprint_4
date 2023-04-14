package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainPage {

    //поле драйвер
    private final WebDriver driver;

    //верхняя кнопка "Заказать"
    private final By btnOrderUp = By.xpath(".//*[@class='Button_Button__ra12g']");

    //нижняя кнопка "Заказать"
    private final By btnOrderDown = By.xpath(".//*[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //кнопка кук "Да все привыкли"
    private final By btnCookie = By.xpath(".//*[@id='rcc-confirm-button']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //метод клика по кнопке кук "Да все привыкли"
    public MainPage clickBtnCookie() {
        WebElement element = driver.findElement(btnCookie);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        //кликнуть на элемент
        driver.findElement(btnCookie).click();
        return this;
    }

    //метод клика по кнопкам "Заказать", в зависимости от переданных параметров
    public MainPage clickBtnOrder(String button) throws InterruptedException {
        switch (button) {
            case "верх":
                driver.findElement(btnOrderUp).click();
            case "низ":
                WebElement element = driver.findElement(btnOrderDown);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
                Thread.sleep(500);
                driver.findElement(btnOrderDown).click();
        }
        return this;
    }

    //метод нахождения вопроса и проверки, что есть ответ
    public boolean faqList(String questionLocator, String answerLocator) throws InterruptedException {
        WebElement element = driver.findElement(By.xpath(questionLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.xpath(questionLocator)).click();
        Thread.sleep(500);
        return driver.findElement(By.xpath(answerLocator)).isEnabled();
    }

    //метод передачи текста ответа в тест для сравнения
    public String faqAnswText(String answerLocator) {
        return driver.findElement(By.xpath(answerLocator)).getText();
    }
}

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

    //массив для FAQ (вопросы)
    private final By[] faqQuestion = {By.xpath(".//*[@id='accordion__heading-0']"),
                                  By.xpath(".//*[@id='accordion__heading-1']"),
                                  By.xpath(".//*[@id='accordion__heading-2']"),
                                  By.xpath(".//*[@id='accordion__heading-3']"),
                                  By.xpath(".//*[@id='accordion__heading-4']"),
                                  By.xpath(".//*[@id='accordion__heading-5']"),
                                  By.xpath(".//*[@id='accordion__heading-6']"),
                                  By.xpath(".//*[@id='accordion__heading-7']")};

    //массив для ответов FAQ
    private final By[] faqAnsw = {By.xpath(".//*[@id='accordion__panel-0']"),
            By.xpath(".//*[@id='accordion__panel-1']"),
            By.xpath(".//*[@id='accordion__panel-2']"),
            By.xpath(".//*[@id='accordion__panel-3']"),
            By.xpath(".//*[@id='accordion__panel-4']"),
            By.xpath(".//*[@id='accordion__panel-5']"),
            By.xpath(".//*[@id='accordion__panel-6']"),
            By.xpath(".//*[@id='accordion__panel -7']")};

    //конструктор класса MainPage
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //метод клика по кнопке кук "Да все привыкли"
    public MainPage clickBtnCookie() {
        //доскроллить до элемента
        WebElement element = driver.findElement(btnCookie);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        //кликнуть на элемент
        driver.findElement(btnCookie).click();
        return this;
    }

    //метод клика по верхней кнопке "Заказать"
    public MainPage clickBtnOrderUp() {
        driver.findElement(btnOrderUp).click();
        return this;
    }
    //метод клика по нижней кнопке "Заказать"
    public MainPage clickBtnOrderDown() {
        //доскроллить до элемента
        WebElement element = driver.findElement(btnOrderDown);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        //кликнуть на элемент
        driver.findElement(btnOrderDown).click();
        return this;
    }
    //метод проверки соответствия текста ответа заданным параметрам
    public boolean faqList(String question, String answer) {
        int j = 0;
        //проверяем, что текст вопроса соответствует
        for (int i = 0; i < 8; i = i + 1) {
            //ищем нужный вопрос - доскроллить до элемента
            WebElement element = driver.findElement(faqQuestion[i]);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            if (question.equals(driver.findElement(faqQuestion[i]).getText())) {
                //клик на вопрос
                driver.findElement(faqQuestion[i]).click();
                //проверяем, что текст ответа соответствует
                if (answer.equals(driver.findElement(faqAnsw[i]).getText())) {
                    j = i;
                }
            }
        }
        return driver.findElement(faqAnsw[j]).isDisplayed();
    }
}

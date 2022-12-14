package RenCreditTest;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {


    WebDriver driver;

    JavascriptExecutor js;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.js = (JavascriptExecutor) this.driver;
    }

    @FindBy(xpath = "/html/body/div/div[1]/div[4]/div/div[2]/div/div[2]/div/div/div[2]/nav[1]/ul/li[2]/a")
    private WebElement cardBtn;


    @FindBy(xpath = "/html/body/div/div[1]/div[4]/div/div[2]/div/div[2]/div/div/div[2]/nav[1]/ul/li[2]/div/div[2]/div/div/div/nav[1]/ul/li[3]/a")
    private WebElement cardMainBtn;


    @FindBy(xpath = "/html/body/div/div[2]/div[3]/div/h2")
    private WebElement anyPurposeCreditBlock;

    @FindBy(xpath = "/html/body/div/div[2]/div[3]/div/div/form/div[2]/div[3]/div[1]/a")
    private WebElement drawUpCreditRequestBtn;

    @Step("Нажатие на кнопку \"Карты\"")
    public void clickOnCardBtn() {
        cardBtn.click();
    }

    @Step("Нажатие на кнопку \"Дебетовая карта \"Главная\"\"")
    public void clickOnMainCardBtn() {
        cardMainBtn.click();
    }

    @Step("Прокрутка страницы до блока \"Кредит на любые цели\"")
    public void scrollToCredit() { js.executeScript("arguments[0].scrollIntoView();", anyPurposeCreditBlock); }

    @Step("Нажатие на кнопку \"Оформить заявку\"")
    public void clickOnDrawUpCreditRequestBtn() { drawUpCreditRequestBtn.click(); }
}

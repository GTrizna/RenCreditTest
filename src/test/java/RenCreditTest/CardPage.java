package RenCreditTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CardPage {

    WebDriver driver;

    public CardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = "/html/body/div/div[2]/article/div/footer/a[1]")
    private WebElement drawUpCardBtn;

    public void clickOnDrawUpCardBtn() {drawUpCardBtn.click();};
}

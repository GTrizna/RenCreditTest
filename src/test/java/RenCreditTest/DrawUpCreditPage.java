package RenCreditTest;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DrawUpCreditPage {

    WebDriver driver;

    JavascriptExecutor js;
    public DrawUpCreditPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.js = (JavascriptExecutor) this.driver;
    }

    @FindBy (xpath = "//*[@id='credit-range-sum']")
    private WebElement sumField;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/form[1]/div/div[3]/div[1]/span")
    private WebElement durationSlider;

    @FindBy(xpath = "//*[@id='credit-select-purpose-button']")
    private WebElement purposeDropList;

    @FindBy(xpath = "//*[@id='ui-id-4']")
    private WebElement purposeCar;

    @FindBy(xpath = "//*[@id='credit-contacts-lastName']")
    private WebElement surnameField;

    @FindBy(xpath = "//*[@id='credit-contacts-firstName']")
    private WebElement nameField;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/form[1]/div/div[5]/div[2]/div[3]/div[2]/label/input")
    private WebElement noPatronymicCheckBox;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/form[1]/div/div[5]/div[2]/div[5]/div/div/div/label[1]/span")
    private WebElement maleRadio;

    @FindBy(xpath = "//*[@id='credit-contacts-birthDate']")
    private WebElement birthDateField;

    @FindBy(xpath = "//*[@id='credit-contacts-mobilePhone']")
    private WebElement phoneNumberField;

    @FindBy(xpath = "//*[@id='credit-contacts-email']")
    private WebElement mailField;

    @FindBy(xpath = "//*[@id='credit-contacts-documentNumber']")
    private WebElement passportNumber;

    @FindBy(xpath = "//*[@id='credit-contacts-issueDate']")
    private WebElement passportDate;

    @FindBy(xpath = "//*[@id='credit-contacts-income']")
    private WebElement mainIncome;

    @FindBy(xpath = "//*[@id='credit-contacts-incomeAdd']")
    private WebElement additionalIncome;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/form[1]/div/div[9]/label/input")
    private WebElement personalDataCheckBox;

    public void fillSumField(@NotNull Integer sum) {
        sumField.clear();
        sumField.sendKeys(sum.toString());
    }

    public void slideDurationRight(@NotNull Integer amount) {
        for (int i =0; i<amount; i++) {
            durationSlider.sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public void openPurposeList() { purposeDropList.click();}

    public void chooseCarPurpose() { purposeCar.click(); }

    public void fillSurname(String surname) {
        surnameField.clear();
        surnameField.sendKeys(surname);
    }

    public void fillName(String name) {
        nameField.clear();
        nameField.sendKeys(name);
        nameField.sendKeys(Keys.ENTER);
    }

    public void togglePatronymic() { js.executeScript("arguments[0].click();",noPatronymicCheckBox); }

    public void setMale() { maleRadio.click(); }

    public void fillBirthDate(String date) { birthDateField.sendKeys(date); }

    public void fillPhoneNumber(String number) {
        phoneNumberField.clear();
        phoneNumberField.sendKeys(number);
    }

    public void fillMail(String mail) {
        mailField.clear();
        mailField.sendKeys(mail);
    }

    public void fillPassportNumber(String number) {
        passportNumber.clear();
        passportNumber.sendKeys(number);
    }

    public void fillPassportDate(String date) {
        passportDate.clear();
        passportDate.sendKeys(date);
    }

    public void fillMainIncome(@NotNull Integer income) {
        mainIncome.clear();
        mainIncome.sendKeys(income.toString());
    }

    public void fillAdditionalIncome(@NotNull Integer income) {
        additionalIncome.clear();
        additionalIncome.sendKeys(income.toString());
    }

    public void togglePersonalDataBox() { js.executeScript("arguments[0].click();",personalDataCheckBox); }

}

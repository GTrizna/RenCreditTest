package RenCreditTest;


import io.qameta.allure.Step;
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

    @Step("Заполнение поля суммы кредита значением {sum}")
    public void fillSumField(Integer sum) {
        sumField.clear();
        sumField.sendKeys(sum.toString());
    }

    @Step("Перемещение ползунка срока кредита вправо на данное число шагов: {amount}")
    public void slideDurationRight(Integer amount) {
        for (int i =0; i<amount; i++) {
            durationSlider.sendKeys(Keys.ARROW_RIGHT);
        }
    }

    @Step("Открытие выпадающий список целей кредита")
    public void openPurposeList() { purposeDropList.click();}

    @Step("Выбор цель кредита \"Покупка авто (новые, б/у)\"")
    public void chooseCarPurpose() { purposeCar.click(); }

    @Step("Заполнение поля фамилии значением {surname}")
    public void fillSurname(String surname) {
        surnameField.clear();
        surnameField.sendKeys(surname);
    }

    @Step("Заполнение поля имени значением {name}")
    public void fillName(String name) {
        nameField.clear();
        nameField.sendKeys(name);
        nameField.sendKeys(Keys.ENTER);
    }

    @Step("Установка чекбокса \"Нет отчества\"")
    public void togglePatronymic() { js.executeScript("arguments[0].click();",noPatronymicCheckBox); }

    @Step("Установка мужского пола")
    public void setMale() { maleRadio.click(); }

    @Step("Заполнения поля даты рождения значением {date}")
    public void fillBirthDate(String date) { birthDateField.sendKeys(date); }

    @Step("Заполнение номера телефона значением {number}")
    public void fillPhoneNumber(String number) {
        phoneNumberField.clear();
        phoneNumberField.sendKeys(number);
    }

    @Step("Заполнение поля электронной почты значением {mail}")
    public void fillMail(String mail) {
        mailField.clear();
        mailField.sendKeys(mail);
    }

    @Step("Заполнение поля серии и номера паспорта значением {number}")
    public void fillPassportNumber(String number) {
        passportNumber.clear();
        passportNumber.sendKeys(number);
    }

    @Step("Заполнение поля даты выдачи паспорта значением {date}")
    public void fillPassportDate(String date) {
        passportDate.clear();
        passportDate.sendKeys(date);
    }

    @Step("Заполнение поля размера основного дохода значением {income}")
    public void fillMainIncome(Integer income) {
        mainIncome.clear();
        mainIncome.sendKeys(income.toString());
    }


    @Step("Заполнение поля размера дополнительного дохода значением {income}")
    public void fillAdditionalIncome(Integer income) {
        additionalIncome.clear();
        additionalIncome.sendKeys(income.toString());
    }

    @Step("Установка чекбокса \"Согласен на предоставление и получение информации\"")
    public void togglePersonalDataBox() { js.executeScript("arguments[0].click();",personalDataCheckBox); }

}

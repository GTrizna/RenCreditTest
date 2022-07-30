package RenCreditTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DrawUpCardPage {

    WebDriver driver;

    public DrawUpCardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id='t1']")
    private WebElement surnameField;

    @FindBy(xpath = "//*[@id='t2']")
    private WebElement nameField;

    @FindBy(xpath = "//*[@id='section_1']/div[2]/div/form/div[1]/div[4]/div/label/div")
    private WebElement noPatronymicCheckBox;

    @FindBy(xpath = "//*[@id='r1-styler']")
    private WebElement maleRadio;

    @FindBy(xpath = "//*[@id='t4']")
    private WebElement phoneNumberField;

    @FindBy(xpath = "//*[@id='t38']")
    private WebElement mailField;

    @FindBy(xpath = "//*[@id='s2-styler']/div[1]/div[1]")
    private WebElement regionDropList;

    @FindBy(xpath = "//*[@id='s2-styler']/div[2]/ul/li[2]")
    private WebElement moscowListElement;

    @FindBy(xpath = "//*[@id='section_1']/div[2]/div/form/div[1]/div[10]/label/div/div")
    private WebElement citizenshipCheckBox;

    @FindBy(xpath = "//*[@id='rf-error']")
    private WebElement noCitizensipError;

    @FindBy(xpath = "//*[@id='section_1']/div[2]/div/form/div[1]/div[11]/div[1]/div/div")
    private WebElement personalDataCheckBox;

    @FindBy(xpath = "//*[@id='n2-error']")
    private WebElement noPersonalDataError;

    public void fillSurname(String surname) {
        surnameField.clear();
        surnameField.sendKeys(surname);
    }

    public void fillName(String name) {
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void togglePatronymic() {noPatronymicCheckBox.click();}

    public void setMale() {maleRadio.click();}

    public void fillPhoneNumber(String number) {
        phoneNumberField.clear();
        phoneNumberField.sendKeys(number);
    }

    public void fillMail(String mail) {
        mailField.clear();
        mailField.sendKeys(mail);
    }

    public void openRegionList() {regionDropList.click();}

    public void chooseMoscow() {moscowListElement.click();}

    public void disableCitizenship() {citizenshipCheckBox.click();}

    public void disablePersonalData() {personalDataCheckBox.click();}

    public boolean checkCitizenshipError() {
       return noCitizensipError.getText().equals("К сожалению, Банк не может выдать дебетовую карту лицам, не являющимся гражданами РФ.");
    }

    public boolean checkPersonalDataError(){
        return noPersonalDataError.getText().equals("Без Вашего согласия на обработку персональных данных мы не можем выпустить Вам дебетовую карту");
    }

}

package RenCreditTest;

import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
@Feature("Тестовое задание")
public class RenCreditTest {

    private static WebDriver driver;
    private static MainPage mainPage;

    private static CardPage cardPage;

    private static DrawUpCardPage drawUpCardPage;

    private static DrawUpCreditPage drawUpCreditPage;

    @BeforeClass
    public static void setup() {

        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", "D:\\JAVA\\chromedriver.exe");
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        mainPage = new MainPage(driver);
        cardPage = new CardPage(driver);
        drawUpCardPage = new DrawUpCardPage(driver);
        drawUpCreditPage = new DrawUpCreditPage(driver);

    }

    @Test (description = "Тест страницы оформления дебетовой карты")
    public void startCardTest() {

        driver.get("https://rencredit.ru/");

        mainPage.clickOnCardBtn();

        mainPage.clickOnMainCardBtn();

        cardPage.clickOnDrawUpCardBtn();

        drawUpCardPage.fillSurname("Иванов");
        drawUpCardPage.fillName("Иван");
        drawUpCardPage.togglePatronymic();
        drawUpCardPage.setMale();
        drawUpCardPage.fillPhoneNumber("1111111111");
        drawUpCardPage.fillMail("Ivanov@ivanov.ru");
        drawUpCardPage.openRegionList();
        drawUpCardPage.chooseMoscow();
        drawUpCardPage.disableCitizenship();
        assert (drawUpCardPage.checkCitizenshipError());
        drawUpCardPage.disablePersonalData();
        assert (drawUpCardPage.checkPersonalDataError());

    }

    @Test(description = "Тест страницы оформления кредита")
    public void startCreditTest() {

        driver.get("https://rencredit.ru/");

        mainPage.scrollToCredit();

        mainPage.clickOnDrawUpCreditRequestBtn();

        drawUpCreditPage.fillSumField(1000000);

        drawUpCreditPage.slideDurationRight(2);

        drawUpCreditPage.openPurposeList();
        drawUpCreditPage.chooseCarPurpose();

        drawUpCreditPage.fillSurname("Иванов");
        drawUpCreditPage.fillName("Иван");
        drawUpCreditPage.togglePatronymic();
        drawUpCreditPage.setMale();
        drawUpCreditPage.fillBirthDate("01.01.2001");
        drawUpCreditPage.fillPhoneNumber("1111111111");
        drawUpCreditPage.fillMail("Ivanov@ivanov.ru");
        drawUpCreditPage.fillPassportNumber("1234567899");
        drawUpCreditPage.fillPassportDate("02.02.2002");
        drawUpCreditPage.fillMainIncome(111);
        drawUpCreditPage.fillAdditionalIncome(0);
        drawUpCreditPage.togglePersonalDataBox();


    }


}

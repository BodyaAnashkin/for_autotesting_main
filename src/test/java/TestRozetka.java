import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import rozetka.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.assertTrue;

public class TestRozetka {
    WebDriver driver;
    HomePage homePage;
    SearchRessultPage srp;
    SignInModal signInModal;
    RegisterUserModal registerUserModal;
    ProductPage productPage;
    private String rozetkaMainPage = "https://rozetka.com.ua/";

    @BeforeClass
    public void initDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void testRozetkaSearchMonitor(){
        driver.get(rozetkaMainPage);
        homePage = new HomePage(driver);
        homePage.setSearchField("Монітор");
        srp = new SearchRessultPage(driver);
        assertThat(srp.getFirstElementTitle(), containsString("Монітор"));
        srp.clickFilterElement("Philips");
        srp.clickFilterElement("60 Гц");
        srp = new SearchRessultPage(driver);
        srp.clickFistElement();//Тупит немного
    }
    @Test
    public void testRegisterRoz(){
        driver.get(rozetkaMainPage);
        homePage = new HomePage(driver);
        homePage.clickButtonUser();
        signInModal = new SignInModal(driver);
        signInModal.clickOnRegisterButton();
        registerUserModal = new RegisterUserModal(driver);
        registerUserModal.setRegisterButton("Имя","Фамилия"," ",
                "testuser@mail.com","Test123");
        assertTrue(registerUserModal.isErrorMassage());
        assertThat(registerUserModal.setErrorMassageText(),
                equalTo(String.format("Введіть номер мобільного телефону")));

    }

    @Test
    public void searchShampuRozetka(){
        driver.get(rozetkaMainPage);
        homePage = new HomePage(driver);
        homePage.setSearchField("шампунь");
        srp = new SearchRessultPage(driver);
        srp.clickFistElement();
        productPage = new ProductPage(driver);
        productPage.clickButtonBuy();
        productPage.clickButtonCartBuy();
    }

    @Test
    public void compareTwoVideoCard(){
        driver.get(rozetkaMainPage);
        homePage = new HomePage(driver);
        homePage.setSearchField("видеокарта");
        srp = new SearchRessultPage(driver);
        srp.clickCompareElement(0);
        srp.clickCompareElement(1);
        srp.clickCompareButtonModalWindow();
        srp.clickCompareButtonRedirect();
    }

    @Test
    public void checkInformationInSpecification(){
        driver.get(rozetkaMainPage);
        homePage = new HomePage(driver);
        homePage.setSearchField("Процесор");
        srp = new SearchRessultPage(driver);
        srp.typeOfSortMaxToMin();
        srp = new SearchRessultPage(driver);
        srp.clickSelectElementByTitle("7950");
        productPage = new ProductPage(driver);
        productPage.clickButtonCharacter();
        productPage.searchValueCharacter("4200 МГц");
    }

    @AfterClass
    public void closerBrowser(){
        //driver.quit();
    }


}

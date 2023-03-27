import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import rozetka.HomePage;
import rozetka.RegisterUserModal;
import rozetka.SearchRessultPage;
import rozetka.SignInModal;

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

    @BeforeTest
    public void initDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void testRozetkaSearch(){
        driver.get("https://rozetka.com.ua/");
        homePage = new HomePage(driver);
        homePage.setSearchField("Монітор");
        srp = new SearchRessultPage(driver);
        assertThat(srp.getFirstElementTitle(), containsString("Монітор"));

    }
    @Test
    public void testRegisterRoz(){
        driver.get("https://rozetka.com.ua/");
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
}

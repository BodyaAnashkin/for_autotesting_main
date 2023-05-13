import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import skillscope.*;

import java.io.IOException;

public class TestSkillScope {

    WebDriver driver;
    MainPage mainPage;
    LoginPage loginPage;
    TalentPage talentPage;
    RegistrationPage regPage;
    EditPage editPage;
    Screenshot screenshot;

    private String skillScopePage = "http://skillscope.pepega.cloud";

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
    public void OpenOtherUser() throws InterruptedException, IOException {
        String email = "Test1@gmail.com", password = "zxc123A!";
        String nameUser = "Alexander Caripo";
        String nameScreen = "ScreenOtherUser.png";
        driver.get(skillScopePage);
        mainPage = new MainPage(driver);
        mainPage.openSignIn();
        loginPage = new LoginPage(driver);
        loginPage.loginUserTalant(email,password);
        Thread.sleep(1000);
        talentPage = new TalentPage(driver);
        talentPage.openPageTalents();
        mainPage = new MainPage(driver);
        mainPage.openUserCardNumber(nameUser);
        screenshot = new Screenshot();
        screenshot.screenshot(driver, nameScreen);
    }

    @Test
    public void registrationUser(){
        String name = "Bohdan", surname = "Petrov", email = "Jaba12@gmail.com",
                password = "qwe789!A", country = "Angola", birthday = "10.10.2001";
        driver.get(skillScopePage);
        mainPage = new MainPage(driver);
        mainPage.openSignUp();
        regPage = new RegistrationPage(driver);
        regPage.registration(name,surname,email,password,country,birthday);
        //deleting accaunt
        editPage = new EditPage(driver);
        editPage.ButtonHelper(driver);
        editPage.clickAndHoldWithDelay(5);
        editPage = new EditPage(driver);
        editPage.confirmDeletion();
    }



    @AfterClass
    public void endTest(){
        // закрытие браузера
        driver.quit();
    }

}

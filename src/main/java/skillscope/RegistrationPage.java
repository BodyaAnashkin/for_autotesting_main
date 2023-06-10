package skillscope;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {

    public RegistrationPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name = 'name']")
    private WebElement nameUser;

    @FindBy(xpath = "//input[@name = 'surname']")
    private WebElement surnameUser;

    @FindBy(xpath = "//input[@name = 'email']")
    private WebElement emailUser;

    @FindBy(xpath = "//input[@name = 'password']")
    private WebElement passwordUser;

    @FindBy(name = "location")
    private WebElement countryUser;

    @FindBy(name = "birthday")
    private WebElement birthdayUser;

    @FindBy(xpath = "//button[text() = 'SIGN UP']")
    private  WebElement buttonSignUp;

    public void registration(String name, String surname, String email, String password, String country, String birthday){
        nameUser.sendKeys(name);
        surnameUser.sendKeys(surname);
        emailUser.sendKeys(email);
        passwordUser.sendKeys(password);
        selectCoutry(country);
        birthdayUser.sendKeys(birthday);
        buttonSignUp.click();
    }
    public void selectCoutry(String country){
            Select countryDropdown = new Select(countryUser);
            countryDropdown.selectByVisibleText(country);
    }
}

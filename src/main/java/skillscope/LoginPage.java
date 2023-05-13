package skillscope;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(xpath = "//input[@name = 'username']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@name = 'password']")
    private WebElement passwordField;

    @FindBy(xpath = "")
    private WebElement sponsorButton;

    @FindBy(xpath = "//button[text() = 'SIGN IN']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }

    public void loginUserTalant(String email, String password){
        loginField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
    }

}

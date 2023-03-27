package rozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.BasePage;

public class RegisterUserModal extends BasePage{
    @FindBy(id = "registerUserName")
    private WebElement registerUserName;
    @FindBy(id = "registerUserSurname")
    private WebElement registerUserSurname;
    @FindBy(id = "registerUserPhone")
    private WebElement registerUserPhone;
    @FindBy(id = "registerUserEmail")
    private WebElement registerUserEmail;
    @FindBy(id = "registerUserPassword")
    private WebElement registerUserPassword;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement registerUserButton;

    @FindBy(xpath = "//div[contains(@class,'validation_type_error')]/form-error")
    private WebElement ErrorMassageTextShort;

    @FindBy(xpath = "//div[contains(@class,'validation_type_error')]/form-error/p[contains(@class,'validation-message')]")
    private WebElement errorMassageText;



    public RegisterUserModal(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void setRegisterButton(String userName, String userSurname, String userPhone, String userEmail, String userPassword){
        registerUserName.sendKeys(userName);
        registerUserSurname.sendKeys(userSurname);
        registerUserPhone.sendKeys(userPhone);
        registerUserEmail.sendKeys(userEmail);
        registerUserPassword.sendKeys(userPassword);
    }

    public void clickOnRegisterButton(){
        registerUserButton.click();
    }

    public String setErrorMassageText(){
        return ErrorMassageTextShort.getText();
    }

    public boolean isErrorMassage(){
        return ErrorMassageTextShort.isDisplayed();
    }
}

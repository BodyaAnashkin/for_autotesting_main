package rozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.BasePage;

public class SignInModal extends BasePage{
    @FindBy(css = ".auth-modal__register-link")
    private WebElement registerButton;

    public SignInModal(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnRegisterButton(){
        registerButton.click();
    }

}

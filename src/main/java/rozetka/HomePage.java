package rozetka;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.BasePage;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@name='search']")
    private WebElement searchField;

    @FindBy(xpath = "//rz-user/button")
    private WebElement userIconButton;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void setSearchField(String searchWord){

        searchField.sendKeys(searchWord, Keys.ENTER);
    }
    public void clickButtonUser(){
        userIconButton.click();
    }
}

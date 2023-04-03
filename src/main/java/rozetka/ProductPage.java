package rozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.BasePage;

public class ProductPage extends BasePage {

    @FindBy(className = "button--green")
    private WebElement buttonGreenBuy;

    @FindBy(className = "cart-receipt__submit")
    private WebElement buttonGreenBuyCart;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickButtonBuy(){
        try {
            Thread.sleep(2000);
            buttonGreenBuy.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickButtonCartBuy(){
        try {
            Thread.sleep(2000);
            buttonGreenBuyCart.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}

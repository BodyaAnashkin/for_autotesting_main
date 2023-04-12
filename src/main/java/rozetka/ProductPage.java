package rozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.BasePage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProductPage extends BasePage {

    @FindBy(className = "button--green")
    private WebElement buttonGreenBuy;

    @FindBy(className = "cart-receipt__submit")
    private WebElement buttonGreenBuyCart;

    //@FindBy(xpath = "//*[text()=' Характеристики ']")
    @FindBy(xpath = "//a[text()=' Характеристики ']")
    private WebElement buttonСharacteristic;

    @FindBy(className = "characteristics-full__value")
    private List<WebElement> listCharacteristic;

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

    public void clickButtonCharacter(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        buttonСharacteristic.click();
    }

    public void searchValueCharacter(String valueCharacter){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        for (WebElement filterElement : listCharacteristic) { // перебираем каждый элемент фильтрации
            String text = filterElement.getText();
            if (text.equals(valueCharacter))
            { // если текст элемента соответствует переданному названию, то нажимаем на него
                break;
            }
        }
    }

}

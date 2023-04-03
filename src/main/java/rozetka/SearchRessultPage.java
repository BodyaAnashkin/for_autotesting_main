package rozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.BasePage;

import java.util.List;

public class SearchRessultPage extends BasePage {

    @FindBy(className = "goods-tile__heading")
    private List<WebElement> searchResultName;

    @FindBy(className = "checkbox-filter__link")
    private List<WebElement> filterElements;

    @FindBy(className = "compare-button")
    private  List<WebElement> compareButton;

    @FindBy(xpath = "//button[@aria-label='Списки порівнянь']")
    private WebElement compareButtonModalWindow;

    @FindBy(className = "comparison-modal__link")
    private WebElement compareButtonRedirect;

    public SearchRessultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getFirstElementTitle(){

        return searchResultName.get(0).getText();
    }

    public void clickFistElement(){
        searchResultName.get(0).click();
    }

    public void clickSelectedElement(int numElement){
        searchResultName.get(numElement).click();
    }


    public void clickCompareElement(int numElement){
        try {
            Thread.sleep(3000);
            compareButton.get(numElement).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickCompareButtonModalWindow(){
        compareButtonModalWindow.click();
    }

    public void clickCompareButtonRedirect(){
        try {
            Thread.sleep(1000);
            compareButtonRedirect.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickFilterElement(String elementName) {
        for (WebElement filterElement : filterElements) { // перебираем каждый элемент фильтрации
            String text = filterElement.getAttribute("data-id");
            if (text.equals(elementName))
            { // если текст элемента соответствует переданному названию, то нажимаем на него
                filterElement.click();
                try {
                    Thread.sleep(2000);
                    break;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }



        }
    }
}

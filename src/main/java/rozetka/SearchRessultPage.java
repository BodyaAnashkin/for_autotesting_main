package rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import page.BasePage;

import java.util.List;
import java.util.concurrent.TimeUnit;

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

    Select selectSorts = new Select(driver.findElement(By.className("select-css")));

    public SearchRessultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getFirstElementTitle(){

        return searchResultName.get(0).getText();
    }

    public void clickFistElement(){
        for (WebElement filterElement : searchResultName) {
            try {
                Coordinates coordinate = ((Locatable) filterElement).getCoordinates();
                coordinate.onPage();
                coordinate.inViewPort();
                filterElement.click();
                break;
            }
            catch (NoSuchElementException ignore) {}
            }
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


    public void typeOfSortRelevantion() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        selectSorts.selectByValue("3: relevance");
    }

    public void typeOfSortMaxToMin(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        selectSorts.selectByValue("2: expensive");
    }

    public void typeOfSortMinToMax(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        selectSorts.selectByValue("1: cheap");
    }
}

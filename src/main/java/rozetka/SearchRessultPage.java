package rozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.BasePage;

import java.util.List;

public class SearchRessultPage extends BasePage {

    @FindBy(className = "goods-tile__heading")
    private List<WebElement> searchResult;

    public SearchRessultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getFirstElementTitle(){
        return searchResult.get(0).getText();
    }
}

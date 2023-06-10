package skillscope;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class EditPage {

    private WebDriver driver;

    public void ButtonHelper(WebDriver driver) {
        this.driver = driver;
    }

    public EditPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "DeleteField_waveBtn__5MPU+")
    private WebElement deleteButton;

    @FindBy(xpath = "//button[text() = 'YES']")
    private WebElement confirmDeletButton;

    public void clickAndHoldWithDelay(int seconds) {
        driver.manage().timeouts().implicitlyWait( 10, TimeUnit.SECONDS );
        Coordinates coordinate = ((Locatable) deleteButton).getCoordinates();
        coordinate.onPage();
        coordinate.inViewPort();
        deleteButton.click();
        Actions actions = new Actions(driver);
        actions.clickAndHold(deleteButton)
                .pause(Duration.ofSeconds(seconds))
                .release()
                .perform();
    }

    public void confirmDeletion(){
        confirmDeletButton.click();
    }


}

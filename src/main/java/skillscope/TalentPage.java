package skillscope;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TalentPage {

    @FindBy(xpath = "//span[text() = 'Talents']")
    private WebElement buttonTalentsPage;

    @FindBy(xpath = "//span[text() = 'Proofs']")
    private WebElement buttonProofsPage;

    @FindBy(xpath = "//button[@class = 'css-4c4npi']")
    private WebElement buttonEditMode;

    @FindBy(xpath = "//button[@class = 'css-1yvvxa3']")
    private WebElement buttonAddProof;

    @FindBy(xpath = "//li[@class = 'css-wfxbd7' and text() = 'Sign out']")
    private WebElement buttonSignOut;

    public TalentPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }

    public void openPageTalents(){
        buttonTalentsPage.click();
    }
    public void openPageProofs(){
        buttonProofsPage.click();
    }
    public void clickButtonEdit(){
        buttonEditMode.click();
    }
    public void clickButtonAddProof(){
        buttonAddProof.click();
    }


}

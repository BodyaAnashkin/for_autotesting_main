package skillscope;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {
    @FindBy(xpath = "//a[text() = 'SIGN IN']")
    private WebElement buttonSingIn;

    @FindBy(xpath = "//a[text()= 'SIGN UP']")
    private WebElement buttonSignUp;

    @FindBy(xpath = "//span[text() = 'Proofs']")
    private WebElement buttonProofsPage;

    @FindBy(xpath = "//div[@class = 'TalentCard_content__nFY94']")
    private List<WebElement> listUsersCard;

    @FindBy(xpath = "//span[@class = 'VisitButton_link__g5Q+u']")
    private List<WebElement> listButtonVisitClick;



    public MainPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }

    public void openSignIn(){
        buttonSingIn.click();
    }

    public void openSignUp(){
        buttonSignUp.click();
    }

    public void openProofsPage(){
        buttonProofsPage.click();
    }

    public void openUserCardNumber(String numberCard){
        int numberCardForButton = 0;
        for (WebElement filterElement : listUsersCard) { // перебираем каждый элемент фильтрации
            String text = filterElement.getText();
            if (text.contains(numberCard))
            { // если текст элемента соответствует переданному названию, то нажимаем на него
                WebElement button = listButtonVisitClick.get(numberCardForButton);
                button.click();
                break;
            }
            numberCardForButton++;
        }
    }


}

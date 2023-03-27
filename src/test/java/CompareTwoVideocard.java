import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class CompareTwoVideocard {

    WebDriver driver = new ChromeDriver();

    @Test
    public void comparecard() {
        driver.manage().window().maximize();
        /*
        //Google Search
        driver.get("https://www.google.com/");
        String searchFieldXpath1 = "//input[@class='gLFyf']";
        WebElement FieldSearch2 = driver.findElement(By.xpath(searchFieldXpath1));
        FieldSearch2.sendKeys("rozetka", Keys.ENTER);
        // клик на первую ссылку в результатах поиска
        String searchrozetka = ".//h3[@class='LC20lb MBeuO DKV0Md']/..";
        WebElement firstLink = driver.findElement(By.xpath(searchrozetka));
        firstLink.click();
            */
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("https://www.rozetka.com.ua/");
            //Поиск на сайте Розетки
            String searchFieldXpath = "//input[@name='search']";
            WebElement FieldSearch = driver.findElement(By.xpath(searchFieldXpath));
            FieldSearch.sendKeys("видеокарта", Keys.ENTER);

            Thread.sleep(5000);
            List<WebElement> listOfElementCard = driver.findElements(By.className("compare-button"));
            WebElement card1 = listOfElementCard.get(0);
            card1.click();
            WebElement card2 = listOfElementCard.get(1);
            card2.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

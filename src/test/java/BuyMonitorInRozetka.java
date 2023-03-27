import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class BuyMonitorInRozetka {
    WebDriver driver = new ChromeDriver();

    @Test
    public void BuyMonitor() {

        driver.manage().window().maximize();
        //Google Search
        driver.get("https://www.google.com/");
        String searchFieldXpath1 = "//input[@class='gLFyf']";
        WebElement FieldSearch2 = driver.findElement(By.xpath(searchFieldXpath1));
        FieldSearch2.sendKeys("rozetka", Keys.ENTER);
        // клик на первую ссылку в результатах поиска
        String searchrozetka = ".//h3[@class='LC20lb MBeuO DKV0Md']/..";
        WebElement firstLink = driver.findElement(By.xpath(searchrozetka));
        firstLink.click();

        //Поиск на сайте Розетки
        String searchFieldXpath = "//input[@name='search']";
        WebElement FieldSearch = driver.findElement(By.xpath(searchFieldXpath));
        FieldSearch.sendKeys("монитор", Keys.ENTER);

        String clickSallerRozetka = "//a[@class = 'checkbox-filter__link' and @data-id = 'Rozetka']";
        WebElement FieldSellerClick = driver.findElement(By.xpath(clickSallerRozetka));
        FieldSellerClick.click();

        List<WebElement> listOfElementMonitor = driver.findElements(By.className("goods-tile__heading"));
        WebElement monitorFirst = listOfElementMonitor.get(1);
        monitorFirst.click();

    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class BuyShampuInRozetka {
    static WebDriver driver;
    ChromeOptions options = new ChromeOptions();
    @Test
    public void buyShampuInRozetkaShampu() {
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
        FieldSearch.sendKeys("шампунь", Keys.ENTER);

        //Выбор шампуня
       // String searchLinkShampu = "//a[@class='goods-tile__heading' and @href='https://rozetka.com.ua/vichy_3337871331290/p48722398/']";
        String searchLinkShampu = ".//span[@class='goods-tile__title' and text()=' Шампунь Vichy Dercos усиленного действия против перхоти для жирных волос и раздраженной кожи головы 390 мл (3337871331290)  ']/..";
        WebElement LinkSpampu = driver.findElement(By.xpath(searchLinkShampu));
        LinkSpampu.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement buttonBuyShampu = driver.findElement(By.className("button--green"));
        buttonBuyShampu.click();

        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        WebElement buttonCheckOpen = driver.findElement(By.className("cart-receipt__submit"));
        buttonCheckOpen.click();

        // закрытие браузера
        //driver.quit();
    }
}

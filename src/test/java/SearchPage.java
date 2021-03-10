import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class SearchPage {

    WebDriver webDriver;

    long timeOut;

    WebElement searchField;


    public SearchPage (WebDriver webDriver, long timeOut) {
        this.webDriver = webDriver;
        this.timeOut = timeOut;
    }

    public SearchPage navigateToTestLocation () {
        webDriver.get("https://rozetka.com.ua/ua/");
        webDriver.manage().window().maximize();
        return this;
    }

    public SearchPage findSearchField () {
        webDriver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
        searchField = webDriver.findElement(By.xpath("//app-root/div/div[1]/rz-header/header/div/div/div/form/div/div/input"));
        return this;
    }

    public SearchPage search (String data) {
        webDriver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
        searchField.sendKeys(data);
        webDriver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
        searchField.sendKeys(Keys.ENTER);
        return this;
    }

    public void check () {
        webDriver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
        WebElement allResultsTab = webDriver.findElement(By.xpath("//rz-search/rz-catalog/div/div[2]/aside/rz-filter-stack/div[1]/div/div/rz-filter-categories/ul/li[1]/a/span[1]"));
        assert (allResultsTab.isDisplayed());
        WebElement clearSearchFieldButton = webDriver.findElement(By.xpath("/html/body/app-root/div/div[1]/rz-header/header/div/div/div/form/div/div/button[2]"));
        clearSearchFieldButton.click();
    }

}

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RozetkaSearchTest {

    WebDriver webDriver;

    @BeforeTest
    public void arrange () {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        webDriver = new ChromeDriver();
        SearchPage searchPage = new SearchPage(webDriver, 10);
        searchPage.navigateToTestLocation();
    }

    @Test(dataProvider = "searchInputProvider", dataProviderClass = SearchInputProvider.class)
    public void act (String data) {
        SearchPage searchPage = new SearchPage(webDriver, 10);
        searchPage.findSearchField().search(data).check();
    }

    @AfterTest
    public void cleanUp () {
        webDriver.quit();
    }

}

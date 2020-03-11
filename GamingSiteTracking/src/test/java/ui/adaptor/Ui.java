package ui.adaptor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Ui {


    @Autowired
    public RegistrationPage register;
    @Autowired
    public LoginPage login;


    @Autowired
    protected static WebDriver driver;


    protected WebDriver getWebDriver() {
        return this.getWebDriver();
    }

    public void deleteCookies() {
        getWebDriver().manage().deleteAllCookies();
    }

    public void refresh() {
        getWebDriver().navigate().refresh();
    }

    protected WebDriverWait wait(int timeOutInSeconds) {
        return new WebDriverWait(getWebDriver(), timeOutInSeconds);
    }
    // Set the browser properties

    public WebDriver setDriverPath(String browser) throws Exception {
        //Check if parameter passed from TestNG is 'firefox'
        if(browser.equalsIgnoreCase("firefox"))
        {
            //create firefox instance
            System.setProperty("webdriver.gecko.driver", "/Users/alisonhawker/IdeaProjects/gameSite/geckodriver");
            driver = new FirefoxDriver();
        }

        //Check if parameter passed as 'chrome'
        if(browser.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "/Users/alisonhawker/IdeaProjects/gameSite/chromedriver");
            driver = new ChromeDriver();
        }

        //Check if parameter passed as 'Edge'
        if(browser.equalsIgnoreCase("IE"))
        {
            System.setProperty("webdriver.ie.driver","/Users/alisonhawker/IdeaProjects/gameSite/");
            InternetExplorerDriver driver;
            driver = new InternetExplorerDriver();
        }

        else
        {
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    /**
     * Click an element and wait for it to become stale
     *
     * @param by
     *          the selector for the element to click
     */
    protected void clickAndWaitForStale(By by) {
        WebElement element = getWebDriver().findElement(by);
        element.click();
        wait(5).until(ExpectedConditions.stalenessOf(element));
    }

    protected boolean isDisplayed(By by) {

        return isDisplayed(by, 1);
    }

    protected boolean isDisplayed(By by, int expectedNumElems) {
        List<WebElement> elems = getWebDriver().findElements(by);
        return isDisplayed(elems, expectedNumElems);
    }

    protected boolean isDisplayed(List<WebElement> elems, int expectedNumElems) {
        if (expectedNumElems < 1) {
            throw new IllegalArgumentException("expectedNumElems must be > 0");
        }

        if (elems.size() != expectedNumElems) {
            return false;
        }
        for (WebElement elem : elems) {
            if (!elem.isDisplayed()) {
                return false;
            }
        }
        return true;
    }


}

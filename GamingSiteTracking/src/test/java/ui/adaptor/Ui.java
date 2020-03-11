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

    // Set the browser properties

    public WebDriver setDriverPath(String browser) throws Exception {
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

    

}

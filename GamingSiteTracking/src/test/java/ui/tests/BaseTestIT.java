package ui.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.adaptor.Ui;

public class BaseTestIT {

    protected WebDriver driver() {
        return this.driver();
    }

  private static WebDriver webDriver;


    private static final String APP_URL = "http://www.game.co.uk";

    @Before
    public void launchApplication() {
        setChromeDriverProperty();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(APP_URL);


    }

    protected Ui ui;

    @After
    public void closeBrowser() {
        driver().quit();
    }

    public void setChromeDriverProperty() {
        System.setProperty("webdriver.chrome.driver", "/Users/alisonhawker/IdeaProjects/GamingSiteTracking/src/test/chromedriver");
    }

    
    protected WebDriverWait wait(int timeOutInSeconds) {
        return new WebDriverWait(driver(), timeOutInSeconds);
    }

   
}



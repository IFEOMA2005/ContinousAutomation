package com.pack.basepage;


import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestbaseSetup {

    private WebDriver driver;


    public  WebDriver getDriver() {
        return driver;
    }

    private static final String APP_URL = "http://www.game.co.uk";


@Before
    public void launchApplication() {
        setChromeDriverProperty();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(APP_URL);
    }

@After
    public void closeBrowser() {
    driver.quit();
    }

    public void setChromeDriverProperty() {
        System.setProperty("webdriver.chrome.driver", "/Users/alisonhawker/IdeaProjects/ConrinousAutomation/src/test/chromedriver");
    }

    protected WebDriverWait wait(int timeOutInSeconds) {
        return new WebDriverWait(driver, timeOutInSeconds);
    }

    public void deleteCookies() {
 driver.manage().deleteAllCookies();
    }

    public void refresh() {

        driver.navigate().refresh();
    }


}

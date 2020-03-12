package com.pack.basepage;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestbaseSetup {

    private static ChromeDriver driver;
    // WebDriver driver;

    public WebDriver getDriver(){
        return driver;
    }

    private static final String APP_URL = "http://www.game.co.uk";

@BeforeClass
    public static void launchApplication() {
        setChromeDriverProperty();
        driver  = new ChromeDriver();
        driver.get(APP_URL);

}

@AfterClass
    public static void tearDown() {
    driver.quit();
    }

   public static void setChromeDriverProperty() {
        System.setProperty("webdriver.chrome.driver", "/Users/alisonhawker/IdeaProjects/ConrinousAutomation/src/test/chromedriver");
    }
/*

    protected WebDriverWait wait(int timeOutInSeconds) {
        return new WebDriverWait(driver, timeOutInSeconds);
    }

    public void deleteCookies() {
 driver.manage().deleteAllCookies();
    }

    public void refresh() {

        driver.navigate().refresh();
    }

*/

}

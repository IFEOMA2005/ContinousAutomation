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

        /**
     * Returns an instance of WebDriverWait for waiting
     *
     * @param timeOutInSeconds
     *          time in second before the wait timeout
     * @return WebDriverWait
     */
    protected WebDriverWait wait(int timeOutInSeconds) {
        return new WebDriverWait(driver(), timeOutInSeconds);
    }

    /**
     * Thread sleep
     *
     * @param timeInMillis
     *          time to sleep in milliseconds
     */
    protected void threadSleep(long timeInMillis) {
        try {
            Thread.sleep(timeInMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    protected void setInputValue(By by, String value) {
        WebElement input = this.driver().findElement(by);
        threadSleep(300);
        input.clear();
        if (value == null || value.isEmpty()) {
            // ENHANCE Find a better way to clear and fire an event on an input element,
            // clear() doesn't fire any keyboard or mouse events.
            // sendKeys(" \b") doesn't work on FFv55 gecko0.19.1-linux64
            // sendKeys(Keys.chord(Keys.CONTROL, "a")) doesn't work on Mac
            // Add one char and remove it to ensure we get a change event, is the only way founded that works on both FF and Chrome
            input.sendKeys("X");
            input.sendKeys(Keys.BACK_SPACE);
        } else {
            input.sendKeys(value);
        }
    }
    protected void clearField(WebElement elem) {
        while (elem.getAttribute("value").length() > 0) {
            elem.sendKeys(Keys.BACK_SPACE);
        }
    }
    /**
     * Click an element and wait for it to become stale
     *
     * @param by
     *          the selector for the element to click
     */
    protected void clickAndWaitForStale(By by) {
        WebElement element = driver().findElement(by);
        element.click();
        wait(5).until(ExpectedConditions.stalenessOf(element));
    }
}



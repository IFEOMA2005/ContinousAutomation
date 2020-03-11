package ui.adaptor;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegistrationPage extends Ui {

    private static final String APP_URL = "http://www.game.co.uk";


    public void waitTillPageLoad() {
        getWebDriver().findElement(By.cssSelector("#pgHome"));
    }


    public void clickRegisterButton() {
        getWebDriver().findElement(By.cssSelector("#registerLink")).click();
    }

    public void clickJoinButton() {
        getWebDriver().findElement(By.cssSelector("join")).click();
    }

    public void clickForMoreInfoButton()  {
        getWebDriver().findElement(By.cssSelector(".join")).click();
    }

    /** Email Address validation **/


    public void setEmailAddress(String email) {
        WebElement emailElem = this.getWebDriver().findElement(By.cssSelector("#username"));
        emailElem .clear();
        emailElem .sendKeys(email);
    }

    public String getEmailAddressErrorMessage() {
        return this.getWebDriver().findElement(By.cssSelector(".field-validation-error")).getText();
    }

    public boolean isEmailFieldEnable() {
        return this.getWebDriver().findElements(By.cssSelector("#UserName")).size() > 0 ? true : false;
    }

    /** Password Element **/
    private WebElement getInputElement() {
        // TODO Auto-generated method stub
        return null;
    }
    // Set the value of the password
    public void setPassword(String password) {
        WebElement passElem = getInputElement();
        passElem.clear();
        passElem.sendKeys(Keys.ENTER);
        getWebDriver().findElement(By.cssSelector("#Password")).sendKeys("");
    }

    // Password Error
    public String getPasswordErrorMessage() {
        return this.getWebDriver().findElement(By.cssSelector(".field-validation-error")).getText();
    }
    // Confirm Password field
    public void setConfirmPassword(String confirmPass) {
        WebElement confirmPassElem = getInputElement();
        confirmPassElem.clear();
        confirmPassElem.sendKeys(Keys.ENTER);
        getWebDriver().findElement(By.cssSelector("#ConfirmPassword")).sendKeys("");
    }


    // To view the password
    public void clickShowButton() {
        getWebDriver().findElement(By.cssSelector(".togglePwd")).click();
    }

    // Click on the submit button
    public void clickSubmitButton() {
        getWebDriver().findElement(By.cssSelector(".btn-signin")).click();
    }

    // Facebook Icon
    public void clickFacebookIcon() {
        getWebDriver().findElement(By.cssSelector("#Facebook")).click();
    }

    // Google Icon
    public void clickGoogleIcon()  {
        getWebDriver().findElement(By.cssSelector("#Google")).click();
    }

    // Microsoft Icon
    public void clickMicrosoftIcon() {
        getWebDriver().findElement(By.cssSelector("#MicrosoftAccount")).click();
    }

    // Twitter Icon
    public void clickTwitterIcon() {
        getWebDriver().findElement(By.cssSelector("#Twitter")).click();
    }

    // Steam Icon
    public void clickSteamIcon() {

        getWebDriver().findElement(By.cssSelector("#Steam")).click();
    }

    // Click on the Register tab
    public void clickRegisterTab() {
        getWebDriver().findElement(By.cssSelector(".dialog-box-tab .glyphicon-plus-sign")).click();
    }

    // Click on Sign in tab
    public void clickLoginTab() {
        getWebDriver().findElement(By.cssSelector(".dialog-box-tab .glyphicon-circle-arrow-right")).click();
    }


    //First I send a text, then I get the text
    public void setEmail(String s) {
        getWebDriver().findElement(By.id("usernamereg-firstName")).sendKeys("$John");
    }

    public String getEmailAddressText() {

        return getWebDriver().findElement(By.id("usernamereg-firstName")).getText();

    }
    public String testInvalidCharacter() {
        //This is the String I want to find
        String firstName="John";

        //If there are these symbols associated with the name-show invalid
        String patternString = ".*$%^#:.*";

        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(firstName);
        if(matcher.find()){

            System.out.println("Invalid Name" );
        }
        else{
            System.out.println("Valid Name");
        }
        return patternString;
    }


}

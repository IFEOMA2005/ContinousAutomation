package coms.pack.common.adaptor;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Registration {

    protected WebDriver driver;



    public void waitTillPageLoad() {

        driver.findElement(By.cssSelector("#pgHome"));
    }


    public void clickRegisterButton() {
        driver.findElement(By.cssSelector("#registerLink")).click();
    }

    public void clickJoinButton() {

    driver.findElement(By.cssSelector("join")).click();
    }

    public void clickForMoreInfoButton()  {
        driver.findElement(By.cssSelector(".join")).click();
    }

    /** Email Address validation **/


    public void setEmailAddress(String email) {
        WebElement emailElem = this.driver.findElement(By.cssSelector("#username"));
        emailElem .clear();
        emailElem .sendKeys(email);
    }

    public String getEmailAddressErrorMessage() {
        return this.driver.findElement(By.cssSelector(".field-validation-error")).getText();
    }

    /** Password Element **/
    private WebElement getInputElement() {
        return null;
    }
    // Set the value of the password
    public void setPassword(String password) {
        driver.findElement(By.cssSelector("#Password")).sendKeys("");
    }

    // Password Error
    public String getPasswordErrorMessage() {
        return this.driver.findElement(By.cssSelector(".field-validation-error")).getText();
    }
    // Confirm Password field
    public void setConfirmPassword(String confirmPass) {
        driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys("");
    }


    // To view the password
    public void clickShowButton() {
        driver.findElement(By.cssSelector(".togglePwd")).click();
    }

    // Click on the submit button
    public void clickSubmitButton() {
        driver.findElement(By.cssSelector(".btn-signin")).click();
    }

    // Facebook Icon
    public void clickFacebookIcon() {
        driver.findElement(By.cssSelector("#Facebook")).click();
    }

    // Google Icon
    public void clickGoogleIcon()  {
        driver.findElement(By.cssSelector("#Google")).click();
    }

    // Microsoft Icon
    public void clickMicrosoftIcon() {
        driver.findElement(By.cssSelector("#MicrosoftAccount")).click();
    }

    // Twitter Icon
    public void clickTwitterIcon() {
        driver.findElement(By.cssSelector("#Twitter")).click();
    }

    // Steam Icon
    public void clickSteamIcon() {

        driver.findElement(By.cssSelector("#Steam")).click();
    }

    // Click on the Register tab
    public void clickRegisterTab() {
        driver.findElement(By.cssSelector(".dialog-box-tab .glyphicon-plus-sign")).click();
    }

    // Click on Sign in tab
    public void clickLoginTab() {
        driver.findElement(By.cssSelector(".dialog-box-tab .glyphicon-circle-arrow-right")).click();
    }


    //First I send a text, then I get the text
    public void setEmail(String s) {
        driver.findElement(By.id("usernamereg-firstName")).sendKeys("$John");
    }

    public String getEmailAddressText() {

        return driver.findElement(By.id("usernamereg-firstName")).getText();

    }
   /* public String testInvalidCharacter() {
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
    }*/


}






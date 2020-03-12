package co.pack.common.tests;

import com.pack.basepage.TestbaseSetup;
import coms.pack.common.adaptor.Registration;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class RegistrationPageIT extends TestbaseSetup {

private Registration register;
private WebDriver driver;

@Before
public void setup() {
    driver=getDriver();
}

    @Test
public void register() {
   register.clickRegisterButton();
    register.setEmail("fiona.bruce@hitme.com");
    register.setPassword("******");
    register.setConfirmPassword("******");
}


}

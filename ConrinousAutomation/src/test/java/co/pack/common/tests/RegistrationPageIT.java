package co.pack.common.tests;

import com.pack.basepage.TestbaseSetup;
import coms.pack.common.adaptor.Registration;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class RegistrationPageIT extends TestbaseSetup {



public WebDriver driver;
@Before
public void setup() {

}

    Registration register = new Registration();

@Test
public void register() throws InterruptedException {
    register.waitTillPageLoad();
register.clickRegisterButton();
register.clickRegisterTab();


}


}

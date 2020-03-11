package ui.tests;

import org.junit.Test;


public class RegistrationPageIT extends BaseTestIT {


    @Test
    public void registerNewUser() {

        ui.register.clickRegisterButton();
        ui.register.setEmail("ifeoma.emodi@mac.com");
        ui.register.setPassword("UzoAmaka123");
        ui.register.setConfirmPassword("Uzoamaka123");

    }
}

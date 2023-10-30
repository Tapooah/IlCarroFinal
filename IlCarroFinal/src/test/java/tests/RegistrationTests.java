package tests;

import madels.User;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {
    @Test
    public void registrationSuccess() {
        User user = new User().setName("Liza").setLastName("Snow").setEmail("fox@mail.com").setPassword("Ff12345$");
    }

}

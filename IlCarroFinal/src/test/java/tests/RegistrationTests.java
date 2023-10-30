package tests;

import madels.User;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {
    @Test
    public void registrationSuccess() {
        int i = (int) (System.currentTimeMillis() / 1000)%3600;
        User user = new User().setName("Liza").setLastName("Snow").setEmail("redfoxy" + i + "@gmail.com").setPassword("Ff12345$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().submit();
    }

}

package tests;

import madels.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    @BeforeTest
    public void preCondition() {
        //if logged --> do logout
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
        app.getHelperUser().click(By.xpath("//div[@class='header']//img[@alt='logo']"));
    }

    @Test
    public void registrationSuccess1() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User().setName("Liza").setLastName("Snow").setEmail("redfoxy" + i + "@gmail.com").setPassword("Ff12345$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "Registered");

    }

    @Test //doesn't work with these Terms of Use
    public void registrationSuccess2() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User().setName("Kiki").setLastName("Snow").setEmail("redfoxy" + i + "@gmail.com").setPassword("Ff12345$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "Registered");

    }

    @Test
    public void registrationWrongPasswordFormat(){
        User user = new User()
                .setName("Roronoa")
                .setLastName("Zolo")
                .setEmail("zolomugivara@gmail.com")
                .setPassword("Zoro");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();

        Assert.assertTrue(app.getHelperUser().isErrorPasswordFormatDisplayed());
        Assert.assertTrue(app.getHelperUser().isErrorPasswordSizeDisplayed());
        Assert.assertTrue(app.getHelperUser().isYallaButtonIsNotActive());
    }
    @AfterMethod
    public void postCondition() {
        app.getHelperUser().clickOK();
    }
}

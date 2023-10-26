package tests;

import manager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp() {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }

    ////////////////////////////////////// ˅ service methods ˅ //////////////////////////////////////

    public void openLoginForm() {
//        wd.findElement(By.xpath("//a[text()=' Log in ']")).click();
        wd.findElement(By.cssSelector("a[href ^='login']")).click();
    }

    public void fillLoginForm(String email, String password) {
        type(By.id("email"), email);
        type(By.id("password"), password);

    }

    public void type(By locator, String text) {
        if (text != null) {
            WebElement elem = wd.findElement(locator);
            elem.click();
            elem.clear();
            elem.sendKeys(text);

        }
    }

    public void submitLogin() {
        wd.findElement(By.cssSelector("button[type='submit']")).click();
//        wd.findElement(By.xpath("//button[text()='Y’alla!']")).click();


    }

    ////////////////////////////////////// ˄ service methods ˄ //////////////////////////////////////
}

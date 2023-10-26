package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
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


    public void submitLogin() {
        wd.findElement(By.cssSelector("button[type='submit']")).click();
//        wd.findElement(By.xpath("//button[text()='Y’alla!']")).click();


    }

    ////////////////////////////////////// ˄ service methods ˄ //////////////////////////////////////
}

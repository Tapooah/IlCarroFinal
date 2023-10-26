package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

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

    public boolean isLogged() {
        List<WebElement> list = wd.findElements(By.cssSelector("a[href ^='/logout']"));
        return !list.isEmpty(); //list.size()>0;
    }

    public void logout() {
        click(By.cssSelector("a[href ^='/logout']"));
    }

    ////////////////////////////////////// ˄ service methods ˄ //////////////////////////////////////
}

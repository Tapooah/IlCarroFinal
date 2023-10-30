package manager;

import madels.User;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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


    public boolean isLogged() {
        List<WebElement> list = wd.findElements(By.cssSelector("a[href ^='/logout']"));
        return !list.isEmpty(); //list.size()>0;
    }

    public void logout() {
        click(By.cssSelector("a[href ^='/logout']"));
    }

    public void openRegistrationForm() {
        click(By.xpath("//a[text()=' Sign up ']"));
    }

    public void fillRegistrationForm(User user) {
        type(By.id("name"), user.getName());
        type(By.id("lastName"), user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public void checkPolicy() {
//        click(By.id("terms-of-use"));
        click(By.cssSelector("label[for='terms-of-use']"));
    }

    public void checkPolicyXY() {
        WebElement label = wd.findElement(By.cssSelector("label[for='terms-of-use']"));
        Rectangle rect = label.getRect();
        int xOffSet = rect.getWidth() / 2;
        int yOffSet = rect.getHeight() / 2;

        Actions actions = new Actions(wd);
        actions.moveToElement(label).release().perform();
        actions.moveByOffset(-xOffSet, -yOffSet).click().release().perform();

    }

    public void clickOK() {
        click(By.xpath("//button[text()='Ok']"));
    }
    ////////////////////////////////////// ˄ service methods ˄ //////////////////////////////////////
}

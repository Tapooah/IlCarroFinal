package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void type(By locator, String text) {
        if (text != null) {
            WebElement elem = wd.findElement(locator);
            elem.click();
            elem.clear();
            elem.sendKeys(text);

        }
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void submit() {
        wd.findElement(By.cssSelector("button[type='submit']")).click();
//        wd.findElement(By.xpath("//button[text()='Y’alla!']")).click();

    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

    public void pause(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

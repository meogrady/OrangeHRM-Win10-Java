package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageLocators {

    public static WebElement login_user_name (WebDriver driver) {
        return driver.findElement(By.id("txtUsername"));
    }

    public static WebElement login_password (WebDriver driver) {
        return driver.findElement(By.id("txtPassword"));
    }

    public static WebElement login_submit_btn (WebDriver driver) {
        return driver.findElement(By.id("btnLogin"));
    }

}

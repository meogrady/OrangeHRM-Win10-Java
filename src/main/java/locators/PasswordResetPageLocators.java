package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PasswordResetPageLocators {

    public static WebElement passwordResetPageHeading (WebDriver driver) {
        return driver.findElement(By.cssSelector(".head h1"));
    }

    public static WebElement authenticateUsernameTextbox (WebDriver driver) {
        return driver.findElement(By.id("securityAuthentication_userName"));
    }

    public static WebElement resetPasswordButton (WebDriver driver) {
        return driver.findElement(By.id("btnSearchValues"));
    }

    public static WebElement resetPasswordCancelButton (WebDriver driver) {
        return driver.findElement(By.cssSelector("#btnCancel.cancel"));
    }

    public static WebElement hiddenResponseMessageLocator (WebDriver driver) {
        return driver.findElement(By.id("securityAuthentication__csrf_token"));
    }
}

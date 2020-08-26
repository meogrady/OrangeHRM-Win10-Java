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

    public static WebElement forgot_password_link (WebDriver driver) {
        return driver.findElement(By.cssSelector("div#forgotPasswordLink a"));
    }

    public static WebElement login_panel_heading (WebDriver driver) {
        return driver.findElement(By.id("logInPanelHeading"));
    }

    ////
    ////    Links at bottom of login page
    ////

    public static WebElement linkedin_group_link (WebDriver driver) {
        return driver.findElement(By.xpath("//img[@alt='LinkedIn OrangeHRM group']"));
    }

    public static WebElement facebook_group_link (WebDriver driver) {
        return driver.findElement(By.xpath("//img[@alt='OrangeHRM on Facebook']"));
    }

    public static WebElement twitter_group_link (WebDriver driver) {
        return driver.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']"));
    }

    public static WebElement youtube_group_link (WebDriver driver) {
        return driver.findElement(By.xpath("//img[@alt='OrangeHRM on youtube']"));
    }
}

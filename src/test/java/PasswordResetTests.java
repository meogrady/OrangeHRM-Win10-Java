import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.LoginPage;
import pageobjects.PasswordResetPage;

import java.util.concurrent.TimeUnit;


public class PasswordResetTests {

    public WebDriver driver;

    @BeforeMethod
    public void setUp () {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait (10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown () {
        driver.close();
    }

    @Test
    public void test_reset_password_with_empty_user_field () {
        LoginPage.clickForgotYourPasswordLink(driver);

        PasswordResetPage.setUsernameTextbox(driver,"");
        PasswordResetPage.clickResetPasswordButton(driver);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='message warning fadable']")));

        String message = PasswordResetPage.getFadablePasswordResetMessageText(driver);

        Assert.assertTrue(message.contains("Could not find a user with given details"));
    }

    @Test
    public void test_reset_password_cancel () {
        LoginPage.clickForgotYourPasswordLink(driver);
        Assert.assertEquals(PasswordResetPage.getPasswordPageHeadingText(driver), "Forgot Your Password?");

        PasswordResetPage.clickResetPasswordCancelButton(driver);
        Assert.assertEquals(LoginPage.getLoginPanelHeaderText(driver), "LOGIN Panel");

    }
}

import io.github.bonigarcia.wdm.WebDriverManager;
import locators.LoginPageLocators;
import locators.PasswordResetPageLocators;
import org.openqa.selenium.JavascriptExecutor;
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

import java.sql.Time;
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
    public void tearDrop () {
        driver.close();
    }

    @Test
    public void test_reset_password () {
        LoginPage.clickForgotYourPasswordLink(driver);

        PasswordResetPage.setUsernameTextbox(driver,"Admin");
        PasswordResetPage.clickResetPasswordButton(driver);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click", PasswordResetPage.getPasswordResetMessageText(driver));
    }

    @Test
    public void test_reset_password_cancel () {
        LoginPage.clickForgotYourPasswordLink(driver);
        Assert.assertEquals(PasswordResetPage.getPasswordPageHeadingText(driver), "Forgot Your Password?");

        PasswordResetPage.clickResetPasswordCancelButton(driver);
        Assert.assertEquals(LoginPage.getLoginPanelHeaderText(driver), "LOGIN Panel");

    }
}

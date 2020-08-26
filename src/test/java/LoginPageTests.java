
import common.SocialMediaLandingPages;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobjects.LoginPage;

import org.openqa.selenium.WebDriver;
import pageobjects.PasswordResetPage;

import java.util.concurrent.TimeUnit;

public class LoginPageTests {

    private WebDriver driver;

    @BeforeMethod
    public void setUp () {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown () {
        driver.quit();
    }

    ////  POSITIVE TESTS  ////
    @Test
    public void test_OrangeHRM_Login_With_Valid_Credentials_Should_Succeed () {
        LoginPage.setLoginUsername(driver, "Admin");
        LoginPage.setLoginPassword(driver, "admin123");
        LoginPage.clickLoginSubmitBtn(driver);
        Assert.assertEquals(driver.findElement(By.id("welcome")).getText(), "Welcome Linda");
    }

    @Test
    public void test_OrangeHRM_Login_With_Lowercase_Username_Should_Succeed () {
        LoginPage.setLoginUsername(driver, "admin");
        LoginPage.setLoginPassword(driver, "admin123");
        LoginPage.clickLoginSubmitBtn(driver);
        Assert.assertEquals(driver.findElement(By.id("welcome")).getText(), "Welcome Linda");
    }

    //// NEGATIVE TESTS ////
    @Test
    public void test_OrangeHRM_Logon_with_Empty_Credentials_Should_Not_Succeed () {
        LoginPage.setLoginUsername(driver, "");
        LoginPage.setLoginPassword(driver, "");
        LoginPage.clickLoginSubmitBtn(driver);
        Assert.assertEquals(driver.findElement(By.id("spanMessage")).getText(), "Username cannot be empty");
    }

    @Test
    public void test_OrangeHRM_Logon_With_Valid_Username_Empty_Password_Should_Not_Succeed () {
        LoginPage.setLoginUsername(driver, "Admin");
        LoginPage.setLoginPassword(driver, "");
        LoginPage.clickLoginSubmitBtn(driver);
        Assert.assertEquals(driver.findElement(By.id("spanMessage")).getText(), "Password cannot be empty");
    }

    @Test
    public void test_OrangeHRM_Logon_with_Empty_Username_Valid_Password_Should_Not_Succeed () {
        LoginPage.setLoginUsername(driver, "");
        LoginPage.setLoginPassword(driver, "admin123");
        LoginPage.clickLoginSubmitBtn(driver);
        Assert.assertEquals(driver.findElement(By.id("spanMessage")).getText(), "Username cannot be empty");
    }

    @Test
    public void test_Forgot_Password_Link_Should_Succeed () {
        LoginPage.clickForgotYourPasswordLink(driver);
        Assert.assertEquals(PasswordResetPage.getPasswordPageHeadingText(driver), "Forgot Your Password?");
    }

    @Test
    public void test_Click_On_LinkedIn_Icon_Should_Take_User_To_Landing_Page () {
        LoginPage.clickLinkedInButton(driver);
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
        }
        Assert.assertEquals(SocialMediaLandingPages.getLinkedInLandingPageHeaderText(driver), "Make the most of your professional life");
    }

    @Test
    public void test_Click_On_Facebook_Icon_Should_Take_User_To_Landing_Page () {
        LoginPage.clickFacebookButton(driver);
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
        }
        Assert.assertEquals(SocialMediaLandingPages.getFacebookLandingPageHeaderText(driver), "OrangeHRM - World's Most Popular Opensource HRIS");
    }

    @Test
    public void test_Click_On_Twitter_Icon_Should_Take_User_To_Landing_Page () {
        LoginPage.clickTwitterButton(driver);
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
        }
        Assert.assertEquals(SocialMediaLandingPages.getTwitterLandingPageHeaderText(driver), "New to Twitter?");
    }

    @Test
    public void test_Click_On_Youtube_Icon_Should_Take_User_To_Landing_Page () {
        LoginPage.clickYoutubeButton(driver);
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
        }
        Assert.assertEquals(SocialMediaLandingPages.getYoutubeLandingPageHeaderText(driver), "OrangeHRM Inc");
    }

}

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobjects.LoginPage;

import org.openqa.selenium.WebDriver;

public class LoginPageTests {

    private WebDriver driver;

    @BeforeMethod
    public void setUp () {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown () {
        driver.close();
    }

    ////  POSITIVE TESTS  ////
    @Test
    public void test_OrangeHRM_Login_With_Valid_Credentials_Should_Succeed () {
        LoginPage.loginUsername(driver, "Admin");
        LoginPage.loginPassword(driver, "admin123");
        LoginPage.loginSubmitBtn(driver);
        Assert.assertEquals(driver.findElement(By.id("welcome")).getText(), "Welcome Admin");
    }

    @Test
    public void test_OrangeHRM_Login_With_Lowercase_Username_Should_Succeed () {
        LoginPage.loginUsername(driver, "admin");
        LoginPage.loginPassword(driver, "admin123");
        LoginPage.loginSubmitBtn(driver);
        Assert.assertEquals(driver.findElement(By.id("welcome")).getText(), "Welcome Admin");
    }

    //// NEGATIVE TESTS ////
    @Test
    public void test_OrangeHRM_Logon_with_Empty_Credentials_Should_Not_Succeed () {
        LoginPage.loginUsername(driver, "");
        LoginPage.loginPassword(driver, "");
        LoginPage.loginSubmitBtn(driver);
        Assert.assertEquals(driver.findElement(By.id("spanMessage")).getText(), "Username cannot be empty");
    }

    @Test
    public void test_OrangeHRM_Logon_With_Valid_Username_Empty_Password_Should_Not_Succeed () {
        LoginPage.loginUsername(driver, "Admin");
        LoginPage.loginPassword(driver, "");
        LoginPage.loginSubmitBtn(driver);
        Assert.assertEquals(driver.findElement(By.id("spanMessage")).getText(), "Password cannot be empty");
    }

    @Test
    public void test_OrangeHRM_Logon_with_Empty_Username_Valid_Password_Should_Not_Succeed () {
        LoginPage.loginUsername(driver, "");
        LoginPage.loginPassword(driver, "admin123");
        LoginPage.loginSubmitBtn(driver);
        Assert.assertEquals(driver.findElement(By.id("spanMessage")).getText(), "Username cannot be empty");
    }

}

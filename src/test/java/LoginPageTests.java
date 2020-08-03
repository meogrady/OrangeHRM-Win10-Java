import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pageobjects.LoginPage;

import org.openqa.selenium.WebDriver;

public class LoginPageTests {

    private WebDriver driver;

    @BeforeSuite
    public void setUp () {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void tearDown () {
        driver.close();
    }

    @Test
    public void test_OrangeHRM_Login_With_Valid_Credentials () {
        LoginPage.loginUsername(driver, "Admin");
        LoginPage.loginPassword(driver, "admin123");
        LoginPage.loginSubmitBtn(driver);

        try {
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println(e);
        }

        Assert.assertEquals(driver.findElement(By.id("welcome")).getText(), "Welcome Admin");
    }

}

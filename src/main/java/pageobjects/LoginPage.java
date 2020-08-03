package pageobjects;

import basepage.BasePage;
import locators.LoginPageLocators;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    /**
     *
     * @param driver
     * @param username
     */
    public static void loginUsername (WebDriver driver, String username) {
        LoginPageLocators.login_user_name(driver).clear();
        LoginPageLocators.login_user_name(driver).sendKeys(username);
    }

    /**
     *
     * @param driver
     * @param password
     */
    public static void loginPassword (WebDriver driver, String password) {
        LoginPageLocators.login_password(driver).clear();
        LoginPageLocators.login_password(driver).sendKeys(password);
    }

    /**
     *
     * @param driver
     */
    public static void loginSubmitBtn (WebDriver driver) {
        LoginPageLocators.login_submit_btn(driver).click();
    }
}

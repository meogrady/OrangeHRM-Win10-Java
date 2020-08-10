package pageobjects;

import basepage.BasePage;
import locators.LoginPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    /**
     *
     * @param driver
     * @param username
     */
    public static void setLoginUsername (WebDriver driver, String username) {
        LoginPageLocators.login_user_name(driver).clear();
        LoginPageLocators.login_user_name(driver).sendKeys(username);
    }

    /**
     *
     * @param driver
     * @param password
     */
    public static void setLoginPassword (WebDriver driver, String password) {
        LoginPageLocators.login_password(driver).clear();
        LoginPageLocators.login_password(driver).sendKeys(password);
    }

    /**
     *
     * @param driver
     */
    public static void clickLoginSubmitBtn (WebDriver driver) {
        LoginPageLocators.login_submit_btn(driver).click();
    }

    /**
     *
     * @param driver
     */
    public static void clickForgotYourPasswordLink (WebDriver driver) {
        LoginPageLocators.forgot_password_link(driver).click();
    }

    public static String getLoginPanelHeaderText (WebDriver driver) {
        return LoginPageLocators.login_panel_heading(driver).getText();
    }
}

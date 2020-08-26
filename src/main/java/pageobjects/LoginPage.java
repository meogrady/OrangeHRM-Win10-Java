package pageobjects;

import basepage.BasePage;
import locators.LoginPageLocators;
import locators.PasswordResetPageLocators;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public LoginPage (WebDriver driver) {
        super(driver);
    }
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

    /**
     *
     * @param driver
     * @return Text from heading element.
     */
    public static String getLoginPanelHeaderText (WebDriver driver) {
        return LoginPageLocators.login_panel_heading(driver).getText();
    }

    /**
     *
     * @param driver
     */
    public static void clickLinkedInButton (WebDriver driver) {
        LoginPageLocators.linkedin_group_link(driver).click();
    }

    /**
     *
     * @param driver
     */
    public static void clickFacebookButton (WebDriver driver) {
        LoginPageLocators.facebook_group_link(driver).click();
    }

    /**
     *
     * @param driver
     */
    public static void clickTwitterButton (WebDriver driver) {
        LoginPageLocators.twitter_group_link(driver).click();
    }

    /**
     *
     * @param driver
     */
    public static void clickYoutubeButton (WebDriver driver) {
        LoginPageLocators.youtube_group_link(driver).click();
    }
}

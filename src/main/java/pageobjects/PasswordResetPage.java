package pageobjects;

import basepage.BasePage;
import locators.PasswordResetPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PasswordResetPage {

    public static void setUsernameTextbox (WebDriver driver, String username) {
        PasswordResetPageLocators.authenticateUsernameTextbox(driver).clear();
        PasswordResetPageLocators.authenticateUsernameTextbox(driver).sendKeys(username);
    }

    public static void clickResetPasswordCancelButton (WebDriver driver) {
        PasswordResetPageLocators.resetPasswordCancelButton(driver).click();
    }

    public static void clickResetPasswordButton (WebDriver driver) {
        PasswordResetPageLocators.resetPasswordButton(driver).click();
    }

    public static String getPasswordResetMessageText (WebDriver driver) {
        return PasswordResetPageLocators.hiddenResponseMessageLocator(driver).getText();
    }

    public static String getPasswordPageHeadingText (WebDriver driver) {
        return PasswordResetPageLocators.passwordResetPageHeading (driver).getText();
    }
}

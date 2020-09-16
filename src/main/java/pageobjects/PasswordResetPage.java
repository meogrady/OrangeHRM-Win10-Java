package pageobjects;

import locators.PasswordResetPageLocators;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


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

    public static String getFadablePasswordResetMessageText (WebDriver driver) {
//        JavascriptExecutor js_exec = (JavascriptExecutor) driver;
//        return js_exec.executeScript("arguments[0].text;", PasswordResetPageLocators.fadableWarningResponseMessageLocator(driver)).toString();
        return PasswordResetPageLocators.fadableWarningResponseMessageLocator(driver).getText();
    }

    public static String getPasswordPageHeadingText (WebDriver driver) {
        return PasswordResetPageLocators.passwordResetPageHeading (driver).getText();
    }

    public static String getWarningMessageText (WebDriver driver) {
        return PasswordResetPageLocators.hiddenMessage(driver).getText();
    }
}

package common;

import locators.SocialMediaLocators;
import org.openqa.selenium.WebDriver;

public class SocialMediaLandingPages {

    public static String getLinkedInLandingPageHeaderText (WebDriver driver) {
        return SocialMediaLocators.LinkedInSignInPageHeader(driver).getText();
    }

    public static String getFacebookLandingPageHeaderText (WebDriver driver) {
        return SocialMediaLocators.FacebookSignInPageHeader(driver).getText();
    }

    public static String getTwitterLandingPageHeaderText (WebDriver driver) {
        return SocialMediaLocators.TwitterSignInPageHeader(driver).getText();
    }

    public static String getYoutubeLandingPageHeaderText (WebDriver driver) {
        return SocialMediaLocators.YouTubeSignInPageHeader(driver).getText();
    }
}

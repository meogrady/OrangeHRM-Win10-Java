package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SocialMediaLocators {

    public static WebElement LinkedInSignInPageHeader (WebDriver driver) {
        return driver.findElement(By.cssSelector("h1.main__subtitle "));
    }

    public static WebElement FacebookSignInPageHeader (WebDriver driver) {
        return driver.findElement(By.cssSelector("a._64-f span"));
    }

    public static WebElement TwitterSignInPageHeader (WebDriver driver) {
        return driver.findElement(By.cssSelector("section.css-1dbjc4n span"));
    }

    public static WebElement YouTubeSignInPageHeader (WebDriver driver) {
        return driver.findElement(By.cssSelector("yt-formatted-string#text.style-scope.ytd-channel-name"));
    }
}

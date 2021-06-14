import java.net.URL;
import java.util.List;
import java.net.MalformedURLException;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.Assert;
import org.testng.annotations.Test;;
public class AppiumTest {
    @Test
    public static void main(String args[]) throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("device", "Samsung Galaxy S8 Plus");
        caps.setCapability("os_version", "7.0");
        caps.setCapability("platformName","android");
        caps.setCapability("project", "GameTest");
        caps.setCapability("build", "0.1");
        caps.setCapability("appPackage","tv.game");
        caps.setCapability("appActivity",".MainActivity");
        caps.setCapability("noReset",true);

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

        AndroidElement twitterElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("AuthoriseWithTwitter_593")));
        twitterElement.click();
        Thread.sleep(20000);
        ElementXPath elxpath = new ElementXPath();
        MobileElement insertUsernameElement = driver.findElementByXPath(elxpath.USERNAME_INPUT);
        insertUsernameElement.sendKeys("sparya60@gmail.com");

        MobileElement insertPasswordElement = driver.findElementByXPath(elxpath.PASSWORD_INPUT);
        insertPasswordElement.sendKeys("61464964");

        MobileElement authorizeElement = driver.findElementByXPath(elxpath.TWITTER_ALLOW_BUTTON);
        authorizeElement.click();
        try {
            MobileElement hamBurger = (MobileElement) new WebDriverWait(driver, 30).until(
                    ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("SvgPicture_HamburgerIcon_001"))
            );
        }catch (TimeoutException e){
            System.out.println("Test Failed");
        }
        System.out.println("Test Passed");

        // The driver.quit statement is required, otherwise the test continues to execute, leading to a timeout.
        driver.quit();
    }
}

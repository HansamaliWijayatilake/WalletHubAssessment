import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageFactory.FacebookLoginPage;

import java.util.HashMap;
import java.util.Map;

import static stringUtils.facebook.UserParams.EMAIL;
import static stringUtils.facebook.UserParams.PASSWORD;

public class FacebookTest {
    WebDriver driver;
    FacebookLoginPage facebookLoginPage;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        WebDriverManager.chromedriver().browserVersion("89.0.4389.128").setup();
        // driver = new ChromeDriver();
        // driver.get("https://www.facebook.com/");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.get("https://www.facebook.com/");

    }

    @Test
    public void loginToFBPostStatus(){
        facebookLoginPage = new FacebookLoginPage(driver);
        facebookLoginPage.loginToFB(EMAIL,PASSWORD);
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        // facebookLoginPage.handleNotificationPopup();

    }

//    @AfterTest
//    public void closeBrowser(){
//        driver.close();
//    }


}

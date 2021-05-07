import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageFactory.FacebookLoginPage;
import pageFactory.FacebookProfilePage;

import java.io.File;
import java.io.IOException;

import static stringUtils.facebook.UserParams.*;

public class FacebookTest {
    WebDriver driver;
    FacebookLoginPage facebookLoginPage;
    FacebookProfilePage facebookProfilePage;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        WebDriverManager.chromedriver().browserVersion("89.0.4389.128").setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.get("https://www.facebook.com/");

    }

    @Test
    public void loginToFBPostStatus(){
        facebookLoginPage = new FacebookLoginPage(driver);
        facebookLoginPage.loginToFB(EMAIL,PASSWORD);
        facebookProfilePage = new FacebookProfilePage(driver);
        facebookProfilePage.updateStatus(STATUS);

        // Take Screenshot for Evidence
        File screenCapture = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Save the screenshot in the given folder with the name FbStatus.png
        try {
            FileUtils.copyFile(screenCapture, new File("src/test/screencapture/FbStatus.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @AfterTest
    public void closeBrowser(){
        driver.close();
    }


}

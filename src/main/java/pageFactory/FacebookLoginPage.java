package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

public class FacebookLoginPage {
    WebDriver driver;

    @FindBy(id="email")
    WebElement email;

    @FindBy(id="pass")
    WebElement password;

    @FindBy(name="login")
    WebElement btnLogin;

    // init elements
    public FacebookLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    // Set email
    public void setEmail(String strEmail){
        email.sendKeys(strEmail);
    }

    // Set password
    public void setPassword(String strPassword){
        password.sendKeys(strPassword);
    }

    // Click Login Button
    public void clickLogin(){
        btnLogin.click();
    }

    public void loginToFB(String email, String password){
        this.setEmail(email);
        this.setPassword(password);
        this.clickLogin();
    }

    public void handleNotificationPopup(){
        Map<String, Object> prefs = new HashMap<String, Object>();
        //Pass the argument 1 to allow and 2 to block
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
    }
}

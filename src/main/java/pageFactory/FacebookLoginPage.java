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

}

package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookProfilePage {
    WebDriver driver;

    @FindBy(xpath = "//a[@aria-label='Home']")
    WebElement homeBtn;

    @FindBy(xpath = ".//div/div/span[@class='a8c37x1j ni8dbmo4 stjgntxs l9j0dhe7']")
    WebElement updateStatusBox;

    @FindBy(css = "div[aria-describedby*='placeholder']")
    WebElement updateStatusTextElement;

    @FindBy(css = "div[aria-label='Post']")
    WebElement btnPost;

    // init elements
    public FacebookProfilePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void clickUpdateStatusBox(){
        updateStatusBox.click();
    }


    // Enter Status
    public void enterStatus(String status){
        updateStatusTextElement.click();
        updateStatusTextElement.sendKeys(status);
    }

    // click on post btn
    public void clickPostBtn(){
        btnPost.click();
    }

    // click on Home btn
    public void clickHomeBtn(){
        homeBtn.click();
    }

    // Update status by clicking on profile icon
    public void updateStatus(String statusStr){
        WebDriverWait wait=new WebDriverWait(driver, 20);
        this.clickHomeBtn();
        wait.until(ExpectedConditions.elementToBeClickable(updateStatusBox));
        this.clickUpdateStatusBox();
        driver.switchTo().activeElement();
        wait.until(ExpectedConditions.elementToBeClickable(updateStatusTextElement));
        this.enterStatus(statusStr);
        this.clickPostBtn();

    }

}

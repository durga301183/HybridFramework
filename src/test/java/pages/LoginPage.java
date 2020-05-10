package pages;

import BaseTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {

//page factory

    @FindBy(xpath= "//input[@placeholder='E-mail address']")
    public static WebElement txtEmail;

    @FindBy(xpath = "//input[@placeholder='Password']")
    public static WebElement txtPassword;

    @FindBy(xpath= "//div[@class='ui fluid large blue submit button']")
    public static WebElement btnSignIn;

    @FindBy(className = "brand-slogan")
    WebElement crmLogo;

    //Initializing the Page Objects:
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    //Actions:
    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean validateCRMImage() {
        return crmLogo.isDisplayed();
    }

    public HomePage login(String username, String password) throws InterruptedException {
        txtEmail.sendKeys(username);
        txtPassword.sendKeys(password);
        btnSignIn.click();
        Thread.sleep(3000);
        return new HomePage();
    }
}


